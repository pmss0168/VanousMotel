<%-- 
    Document   : register
    Created on : Mar 12, 2024, 10:08:37 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix   ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>J2EE Application</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="/asset/css/register.css"/>
    </head>
    <body>
        <c:if test="${not empty nofty}">
            <div class="alert alert-danger" role="alert">${nofty}</div>
        </c:if>
        <div class="container">
            <form action="/registerController" name="register" method="post">
                <div class="title">
                    <h2>Đăng ký</h2>
                </div>
                <div class="formRegister">
                    <div class="input">
                        <p>Họ và tên</p>
                        <input type="text" name="fullname" placeholder="Nhập họ tên..." minlength="8" required>
                    </div>
                    <div class="input">
                        <p>Số điện thoại</p>
                        <input type="text" name="phone" placeholder="Nhập số điện thoại..."  minlength="10" required>
                    </div>
                    <div class="input">
                        <p>Tài khoản</p>
                        <input type="text" name="username" placeholder="Nhập tài khoản..." minlength="5" required>
                    </div>
                    <div class="input">
                        <p>Mật khẩu</p>
                        <input type="password" name="password" placeholder="Nhập mật khẩu..." minlength="8" required>
                    </div>
                    <div class="input">
                        <p>Nhập lại mật khẩu</p>
                        <input type="password" name="repassword" placeholder="Nhập lại mật khẩu..." minlength="8" required>
                    </div>
                    <br>
                    <button class="btn" type="submit">Xác nhận</button>
                    <p>Bạn đã có tài khoản? <a href="index.jsp">Đăng nhập</a></p>
                </div>
            </form>
        </div>
    </body>
</html>
