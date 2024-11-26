<%-- 
    Document   : index
    Created on : Mar 12, 2024, 10:07:42 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>J2EE Application</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="/asset/css/login.css"/>
    </head>
    <body>
        <c:if test="${not empty nofty}">
            <div class="alert alert-danger" role="alert">${nofty}</div>
        </c:if>
        <div class="container">
            <form action="/loginController" name="login" method="post">
                <div class="title">
                    <h2>Đăng nhập</h2>
                </div>
                <div class="formLogin">
                    <div class="input">
                        <p>Tài khoản</p>
                        <input type="text" name="user" placeholder="Nhập tài khoản..." minlength="5" required>
                    </div>
                    <div class="input">
                        <p>Mật khẩu</p>
                        <input type="password" name="pass" placeholder="Nhập mật khẩu..." minlength="8" required>
                    </div>
                    <br>
                    <button class="btn" type="submit">Xác nhận</button>
                    <p>Bạn chưa có tài khoản? <a href="/register.jsp">Đăng ký</a></p>   
                </div>
            </form>
        </div>
    </body>
</html>
