<%-- 
    Document   : category_management
    Created on : Mar 21, 2024, 7:50:34 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "entity.Category"%>
<%@page import = "entity.Util"%>
<%@page import = "database.dao.category.CategoryDao"%>
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
        <h2>Quản lý loại phòng</h2>
        <a href="/"></a>
        <form action="/addCategory" method="post">
            <table style="height: 200px; width: 40%; border: 1px solid rgba(0,0,0,0.3); margin: 10px auto;">
                <tr class="bg-danger-subtle">
                    <td colspan="2">
                        <h3 class="text-center">Thêm loại phòng</h3>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Loại phòng</td>
                    <td>
                        <input class="p-1" style="width: 90%" type="text" name="name" required>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Giá phòng</td>
                    <td>
                        <input class="p-1" style="width: 90%" type="number" name="price" required>
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
                <th>#</th>
                <th>Loại Phòng</th>
                <th>Giá</th>
                <th>Xóa loại phòng</th>
                <th>Sửa loại phòng</th>
            </tr>
            <%CategoryDao cd = new CategoryDao();
            List<Category> listC = cd.getAll();
            for(Category c : listC){%>
            <tr class="item">
                <td><%=c.getIdcate()%></td>
                <td><%=c.getCate()%></td>
                <td><%=Util.formatToVND(c.getPrice())%></td>
                <td>
                    <form action="/removeCategory" method="post">
                        <input type="hidden" name="id" value="<%=c.getIdcate()%>" />
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </form> 
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editCategoryForm" data-bs-cate="<%=c.getCate()%>" data-bs-whatever="<%=c.getIdcate()%>">Sửa</button>
                </td>
            </tr>
            <%}%>
        </table>
        <div class="modal fade" id="editCategoryForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-danger-subtle">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Sửa loại phòng:</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/editCategory" method="post">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">Loại phòng:</label>
                                <input name="category" type="text" class="form-control" id="recipient-name" required>
                                <input name="id" type="hidden" class="getId">
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Giá phòng:</label>
                                <input name="price" type="number" class="form-control" id="message-text" required>
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
            const editCategoryForm = document.getElementById('editCategoryForm');
            if (editCategoryForm) {
                editCategoryForm.addEventListener('show.bs.modal', event => {
                    // Button that triggered the modal
                    const button = event.relatedTarget;
                    // Extract info from data-bs-* attributes
                    const recipient = button.getAttribute('data-bs-whatever');
                    const cate = button.getAttribute('data-bs-cate');
                    // If necessary, you could initiate an Ajax request here
                    // and then do the updating in a callback.

                    // Update the modal's content.
                    const modalTitle = editCategoryForm.querySelector('.modal-title');
                    const modalBodyInput = editCategoryForm.querySelector('.modal-body input');
                    const getId = editCategoryForm.querySelector('.modal-body .getId');
                    modalTitle.textContent = `Sửa loại phòng: ${recipient}`;
                    modalBodyInput.value = cate;
                    getId.value = recipient;
                });
            }
        </script>
        <%@include file="/footer.jsp" %>
