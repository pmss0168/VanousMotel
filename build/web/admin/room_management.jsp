<%-- 
    Document   : room_management
    Created on : Mar 21, 2024, 7:50:22 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "entity.Room"%>
<%@page import = "entity.RoomCategory"%>
<%@page import = "entity.Util"%>
<%@page import = "database.dao.DAO"%>
<%@page import = "java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="/header.jsp" %>
        <%@include file="/admin/prevent_user_access.jsp" %>
        <h2>Quản lý phòng</h2>
        <form action="/addRoom" method="post">
            <table style="height: 200px; width: 40%; border: 1px solid rgba(0,0,0,0.3); margin: 10px auto;">
                <tr class="bg-danger-subtle">
                    <td colspan="2">
                        <h3 class="text-center">Thêm phòng</h3>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Số phòng</td>
                    <td>
                        <input class="p-1" style="width: 90%" type="number" name="room" required>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Loại phòng</td>
                    <td>
                        <input class="p-1" style="width: 90%" type="number" name="category" required>
                    </td>
                </tr>
                <tr>
                    <td class="text-center" colspan="2">
                        <input class="btn btn-primary" type="submit" value="Xác nhận">
                        <input class="btn btn-danger" type="reset" value="Hủy">
                    </td>
                </tr>
            </table>
        </form>
        <table class="table table-bordered table-striped list">
            <tr class="table-danger">
                <th>Số phòng</th>
                <th>Tình trạng phòng</th>
                <th>Loại phòng</th>
                <th>Xóa phòng</th>
                <th>Thêm phòng</th>
            </tr>
            <%DAO rd = new DAO();
            List<RoomCategory> listR = rd.getAllRoom();
            for(RoomCategory r : listR){%>
            <tr class="item">
                <td><%=r.getRoom()%></td>
                <%if(r.getStatus() == 0){%>
                <td>Trống</td>
                <%}else{%>
                <td>Được thuê</td>
                <%}%>
                <td><%=r.getCategory()%></td>
                <td>
                    <form action="/removeRoom" method="post">
                        <input type="hidden" name="room" value="<%=r.getRoom()%>" />
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </form> 
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="<%=r.getRoom()%>">Sửa</button>
                </td>
            </tr>
            <%}%>
        </table>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-danger-subtle">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Sửa phòng:</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/editRoom" method="post">
                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">Số phòng:</label>
                                <input name="roomEdit" type="number" class="form-control" id="recipient-name" required>
                                <input name="room" type="hidden" class="getRoomOrigin">
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Loại phòng:</label>
                                <input name="category" type="number" class="form-control" id="message-text" required>
                            </div>  

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Xác nhận</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="/pagination_table.jsp" %>
        <c:if test="${not empty nofty}">
            <script>
                alert("${nofty}");
            </script>
        </c:if>
        <script>
            const exampleModal = document.getElementById('exampleModal');
            if (exampleModal) {
                exampleModal.addEventListener('show.bs.modal', event => {
                    // Button that triggered the modal
                    const button = event.relatedTarget;
                    // Extract info from data-bs-* attributes
                    const recipient = button.getAttribute('data-bs-whatever');
                    // If necessary, you could initiate an Ajax request here
                    // and then do the updating in a callback.

                    // Update the modal's content.
                    const modalTitle = exampleModal.querySelector('.modal-title');
                    const modalBodyInput = exampleModal.querySelector('.modal-body input');
                    const getRoomOrigin = exampleModal.querySelector('.modal-body .getRoomOrigin');
                    modalTitle.textContent = `Sửa phòng: ${recipient}`;
                    modalBodyInput.value = recipient;
                    getRoomOrigin.value = recipient;
                });
            }
        </script>
        <%@include file="/footer.jsp" %>