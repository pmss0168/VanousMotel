<%-- 
    Document   : user_management
    Created on : Mar 21, 2024, 7:50:08 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "entity.Users"%>
<%@page import = "database.dao.user.UserDao"%>
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
        <h2>Quản lý người dùng</h2>
        <div>
            <table class="table table-bordered table-striped list">
                <tr class="table-danger">
                    <th>Username</th>
                    <th>Họ tên</th>
                    <th>Phone</th>
                    <th>Admin</th>
                    <th>Nhân viên</th>
                    <th>Thêm/xóa admin</th>
                    <th>Thêm/xóa nhân viên</th>
                </tr>
                <%UserDao ud = new UserDao();
                List<Users> listUser = ud.getAll();
                for(Users u : listUser){%>
                <tr class="item">
                    <td><%=u.getUsername()%></td>
                    <td><%=u.getFullname()%></td>
                    <td><%=u.getPhone()%></td>
                    <td><%=u.getIsAdmin()%></td>
                    <td><%=u.getIsStaff()%></td>
                    <%if(u.getIsAdmin() == 0){%>
                    <td>
                        <form action="/addAdmin" method="post">
                            <input type="hidden"  name="username" value="<%=u.getUsername()%>"/>
                            <button type="submit" class="btn btn-primary">Thêm</button>
                        </form>
                    </td>
                    <%}else{%>
                    <td>
                        <form action="/removeAdmin" method="post">
                            <input type="hidden"  name="username" value="<%=u.getUsername()%>"/>
                            <button type="submit" class="btn btn-danger">Xóa</button>
                        </form>
                    </td>
                    <%}%>
                    <%if(u.getIsStaff() == 0){%>
                    <td>
                        <form action="/addStaff" method="post">
                            <input type="hidden"  name="username" value="<%=u.getUsername()%>"/>
                            <button type="submit" class="btn btn-primary">Thêm</button>
                        </form>
                    </td>
                    <%}else{%>
                    <td>
                        <form action="/removeStaff" method="post">
                            <input type="hidden"  name="username" value="<%=u.getUsername()%>"/>
                            <button type="submit" class="btn btn-danger">Xóa</button>
                        </form>
                    </td>
                    <%}%>
                </tr>
                <%}%>
            </table>
        </div>
        <%@include file="/pagination_table.jsp" %>
        <%@include file="/footer.jsp" %>
