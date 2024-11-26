<%-- 
    Document   : info
    Created on : Mar 18, 2024, 1:14:28 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="header.jsp"%>
<!--        <h2>Thông tin người dùng</h2>
        <div>
            <p><strong>Tên người dùng:</strong> <%=user.getFullname()%></p>
            <p><strong>Tài khoản:</strong> <%=user.getUsername().substring(0,2)%>******<%=user.getUsername().substring(user.getUsername().length()-2)%></p>
            <p><strong>Số điện thoại:</strong> ******<%=user.getPhone().substring(user.getPhone().length() - 3)%></p>
        </div>-->
        <div class="card d-flex justify-content-center align-items-center" style="width: 20rem; margin: 1.5rem auto">
            <img style="width: 200px; height: 200px" src="/asset/images/man.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h3 class="card-title mb-3">Thông tin người dùng</h3>
                <p><strong>Tên:</strong> <%=user.getFullname()%></p>
                <p><strong>Tài khoản:</strong> <%=user.getUsername().substring(0,2)%>******<%=user.getUsername().substring(user.getUsername().length()-2)%></p>
                <p><strong>Số điện thoại:</strong> ******<%=user.getPhone().substring(user.getPhone().length() - 3)%></p>
                <%if(user.getIsStaff() == 1){%>
                    <p><strong>Vai trò:</strong> Nhân viên</p>
                <%}else if(user.getIsAdmin() == 1){%>
                    <p><strong>Vai trò:</strong> Quản trị viên</p>
                <%}else if(user.getIsAdmin() == 0 && user.getIsStaff() == 0){%>
                    <p><strong>Vai trò:</strong> Khách hàng</p>
                <%}%>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="<%=user.getUsername()%>">Đổi mật khẩu </button>
            </div>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-danger-subtle">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Đổi mật khẩu:</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/changePassword" method="post">
                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">Mật khẩu cũ:</label>
                                <input name="oldPassword" type="password" minlength="8" class="form-control" id="recipient-name" required>
                                <input name="user" type="hidden" class="getRoomOrigin">
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Mật khẩu mới:</label>
                                <input name="newPassword" type="password" minlength="8" class="form-control" id="message-text" required>
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
                    //modalBodyInput.value = recipient;
                    getRoomOrigin.value = recipient;
                });
            }
        </script>
        <%@include file="footer.jsp" %>
