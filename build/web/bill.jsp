<%-- 
    Document   : bill
    Created on : Mar 18, 2024, 11:42:21 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix   ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import = "entity.Booking"%>
<%@page import = "entity.Category"%>
<%@page import = "entity.Room"%>
<%@page import = "entity.Util"%>
<%@page import = "entity.RoomCategory"%>
<%@page import = "database.dao.DAO"%>
<%@page import = "database.dao.category.CategoryDao"%>
<%@page import = "database.dao.booking.BookingDao"%>
<%@page import = "database.dao.room.RoomDao"%>
<%@page import = "java.util.*"%>
<%@page import = "java.time.*"%>
<%@page import = "java.text.DecimalFormat"%>
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
        <%@include file="/prevent_access.jsp" %>
        <h2>Hóa đơn</h2>
        <div class="list" style="display: flex; justify-content: center; flex-wrap: wrap; gap: 20px; padding: 10px;">
            <%BookingDao bd = new BookingDao();
            List<Booking> listBooking = bd.getAll();
            for(Booking b : listBooking){
                if(b.getUser().equals(user.getUsername())){%>
            <form class="item" action="/cancelBill" method="post">
                <div style="padding: 20px; border: 1px solid rgba(0,0,0,0.3); width: 350px;">
                    <p><strong>Số phòng:</strong> <%=b.getRoom()%></p>
                    <p><strong>Ngày đặt:</strong> <%=b.getCheckin()%></p>
                    <p><strong>Ngày trả:</strong> <%=b.getCheckout()%></p>
                    <p><strong>Tổng tiền:</strong> <%=Util.formatToVND(b.getPrice())%></p>
                    <%if(b.getIsCancel() == 1){%>
                    <p class="p-3 text-danger-emphasis bg-danger-subtle border border-danger-subtle rounded-3" style="color: red">Đơn đã được hủy</p>
                    <input class="btn btn-danger" type="submit" value="Hủy đặt" disabled/>
                    <%}else if(b.getIsSuccess() == 1){%>
                    <p class="p-3 text-success-emphasis bg-success-subtle border border-success-subtle rounded-3" style="color: chartreuse">Hoàn tất</p>
                    <input class="btn btn-danger" type="submit" value="Hủy đặt" disabled/>
                    <%}else if(b.getIsConfirm() == 1){%>
                    <p class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3" style="color: #1da1f2">Đã xác nhận</p>
                    <input class="btn btn-danger" type="submit" value="Hủy đặt" disabled/>
                    <%}else if(b.getIsCancel() == 0 && b.getIsSuccess() == 0 && b.getIsConfirm() == 0){%>
                    <p class="p-3 text-info-emphasis bg-info-subtle border border-info-subtle rounded-3" style="color: #1da1f2">Đặt phòng thành công</p>
                    <input class="btn btn-danger" type="submit" value="Hủy đặt"/>
                    <%}%>
                    <input type="hidden" name="id" value="<%=b.getId()%>"/>
                    <input type="hidden" name="room" value="<%=b.getRoom()%>"/>
                    <input type="hidden" name="checkin" value="<%=b.getCheckin()%>"/>
                    <input type="hidden" name="checkout" value="<%=b.getCheckout()%>"/>
                    <input type="hidden" name="price" value="<%=b.getPrice()%>"/>
                </div>
            </form>
            <%}
        }%>
        </div>
        <%@include file="/pagination.jsp" %>
        <c:if test="${not empty nofty}">
            <script>
                alert("${nofty}");
            </script>
        </c:if>
        <%@include file="/footer.jsp" %>
