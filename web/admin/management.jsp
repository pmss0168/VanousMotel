<%-- 
    Document   : management
    Created on : Mar 16, 2024, 3:04:24 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "entity.Users"%>
<%@page import = "entity.Util"%>
<%@page import = "database.dao.booking.BookingDao"%>
<%@page import = "database.dao.room.RoomDao"%>
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
        <h2>Thông tin</h2>
        <%  BookingDao bd = new BookingDao();
            RoomDao rd = new RoomDao();%>
        <div class="d-flex p-1 flex-wrap justify-content-center" style="gap: 20px;">
            <div class="p-3 border border-primary d-flex flex-column justify-content-center align-items-center" style="width: 350px; height: 200px">
                <p class="fs-4 text-primary">Tổng số lượng phòng</p>
                <div class="fs-1 fw-bold text-primary"><%=rd.countAllRoom()%></div>
            </div>
            <div class="p-3 border border-info d-flex flex-column justify-content-center align-items-center" style="width: 350px; height: 200px">
                <p class="fs-4 text-info">Phòng đang được đặt</p>
                <div class="fs-1 fw-bold text-info"><%=rd.countBookedRoom()%></div>
            </div>
            <div class="p-3 border border-secondary d-flex flex-column justify-content-center align-items-center" style="width: 350px; height: 200px">
                <p class="fs-4 text-secondary">Phòng đang trống</p>
                <div class="fs-1 fw-bold text-secondary"><%=rd.countEmptyRoom()%></div>
            </div>
            <div class="p-3 border border-danger d-flex flex-column justify-content-center align-items-center" style="width: 350px; height: 200px">
                <p class="fs-4 text-danger">Hóa đơn đã hủy</p>
                <div class="fs-1 fw-bold text-danger"><%=bd.countAllCancel()%></div>
            </div>
            <div class="p-3 border border-success d-flex flex-column justify-content-center align-items-center" style="width: 350px; height: 200px">
                <p class="fs-4 text-success">Hóa đơn đã thanh toán</p>
                <div class="fs-1 fw-bold text-success"><%=bd.countAllSuccess()%></div>
            </div>
            <div class="p-3 border border-warning d-flex flex-column justify-content-center align-items-center" style="width: 350px; height: 200px">
                <p class="fs-4 text-warning">Tổng doanh thu</p>
                <div class="fs-1 fw-bold text-warning text-center"><%=Util.formatToVND(bd.totalAmount())%></div>
            </div>
        </div>
        <%@include file="/footer.jsp" %>
