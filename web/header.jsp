<%-- 
    Document   : newjsp
    Created on : Mar 17, 2024, 5:02:35 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "entity.Users"%>
<%@page import = "entity.Util"%>
<style>
    a{
        text-decoration: none;
        color: #db2a34;
    }
    ul{
        margin: 0px;
    }   
</style>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<%Users user = (Users)session.getAttribute("account");
        if(!Util.checkSession(session)){
            response.sendRedirect("/index.jsp");
    }
        else{%>
<div style="height: 100px; display: flex; justify-content: space-between; padding: 0px 1rem; box-shadow: 0px -1px 8px 1px; z-index: 99">
    <div><img style="border-radius: 50%" src="/asset/images/logo.png" width="100px" height="100px" alt="logo"/></div>
    <div style="display: flex; align-content: center">
        <ul style="display: flex; justify-content: space-around; align-items: center; list-style: none; gap: 20px">
            <%if(user.getIsAdmin() == 0 && user.getIsStaff() == 0){%>   
            <li><a href="/home.jsp">Trang chủ</a></li>
            <li><a href="/booking.jsp">Đặt phòng</a></li>
            <li><a href="/bill.jsp">Xem hóa đơn</a></li>
                <%}else if(user.getIsAdmin() == 1 && user.getIsStaff() == 0){%>
            <li><a href="/admin/management.jsp">Thống kê</a></li>
            <li><a href="/admin/user_management.jsp">Quản lý người dùng</a></li>
            <li><a href="/admin/room_management.jsp">Quản lý phòng</a></li>
            <li><a href="/admin/category_management.jsp">Quản lý loại phòng</a></li>
            <li><a href="/admin/booking_management.jsp">Quản lý đặt phòng</a></li>
                <%}else if(user.getIsAdmin() == 0 && user.getIsStaff() == 1){%>
            <li><a href="/admin/management.jsp">Thống kê</a></li>
            <li><a href="/booking.jsp">Đặt phòng</a></li>
            <li><a href="/admin/booking_management.jsp">Quản lý đặt phòng</a></li>
                <%}%>
        </ul>
    </div>
    <div style="display: flex; gap: 10px; align-items: center">
        <p style="margin: 0px;">Xin chào, <a href="/info.jsp"><%=user.getFullname()%></a></p>
        <a href="/logoutController"><button class="btn btn-danger"><i class='bx bx-log-out-circle'></i></button></a>
    </div>
</div>