<%-- 
    Document   : home
    Created on : Mar 14, 2024, 8:46:22 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "entity.Users"%>
<%@page import = "entity.Util"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            .frontBanner h4::before{
                position: absolute;
                content: "";
                width: 160px;
                height: 2px;
                background: #db2a34;
                top: 0;
                right: -190px;
                top: 50%;
                transform: translateY(-50%);
                
            }
            .frontBanner h4::after{
                position: absolute;
                content: "";
                width: 160px;
                height: 2px;
                background: #db2a34;
                top: 0;
                left: -190px;
                top: 50%;
                transform: translateY(-50%);
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="prevent_access.jsp" %>
        <div style="position: relative; height: 600px">
            <div class="frontBanner" style=" display: flex; flex-direction: column; align-items: center; justify-content: center;position: absolute;z-index: 2; width: 100%; height: 100%; padding: 1rem; background: rgba(0,0,0,0.5);">
                <h1 style="text-align: center;color: whitesmoke; font-size: xxx-large; font-family: 'Noto Serif', serif; font-weight: 700; ">VanouS Kính Chào Quý Khách!</h1>
                <h4 style="position: relative; color: whitesmoke; font-family: 'Lato', sans-serif;">Motel & Relax</h4> 
                <a href="booking.jsp"><button class="btn btn-danger">Đặt phòng</button></a>
            </div>
            <img style="opacity: 0.9; object-fit: cover 
                 " src="/asset/images/h1_hero.jpg" width="100%" height="100%" alt="banner"/>
        </div>
        <%@include file="footer.jsp" %>
