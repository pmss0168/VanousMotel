<%-- 
    Document   : booking
    Created on : Mar 15, 2024, 3:47:28 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix   ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import = "entity.Booking"%>
<%@page import = "entity.Category"%>
<%@page import = "entity.Room"%>
<%@page import = "entity.RoomCategory"%>
<%@page import = "entity.Util"%>
<%@page import = "entity.RoomCategory"%>
<%@page import = "database.dao.DAO"%>
<%@page import = "database.dao.category.CategoryDao"%>
<%@page import = "database.dao.booking.BookingDao"%>
<%@page import = "database.dao.room.RoomDao"%>
<%@page import = "java.util.*"%>
<%@page import = "java.time.*"%>
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
        <%if(user.getIsStaff() == 1){%>
        <%@include file="/admin/prevent_user_access.jsp" %>
        <%}else{%>
        <%@include file="/prevent_access.jsp" %>
        <%}%>
        <h2>Đặt phòng nhà nghỉ</h2>
        <h3 class="text-center">Bảng giá</h3>
        <table class="table table-bordered table-striped">
            <tr class="table-danger">
                <th>STT</th>
                <th>Loại phòng</th>
                <th>Giá</th>
            </tr>
            <%DAO dao = new DAO();
            CategoryDao cd = new CategoryDao();
            BookingDao bd = new BookingDao();
            RoomDao rd = new RoomDao();
            List<RoomCategory> listRoom = dao.getAllRoom();
            List<Category> listCategory = cd.getAll();
//            bd.updateStatus();
            for(Category cate : listCategory){%>
            <tr>
                <td><%=cate.getIdcate()%></td>
                <td><%=cate.getCate()%></td>
                <td><%=Util.formatToVND(cate.getPrice())%></td>
            </tr>
            <%}%>
        </table>
        <h3 class="text-center">Booking</h3>
        <div class="bg-danger-subtle" style="display: flex; justify-content: space-around; padding: 1rem 0px">
            <h6 style="width: 120px">Số phòng</h6>
            <h6 style="width: 120px">Tình trạng thuê</h6>
            <h6 style="width: 120px">Loại phòng</h6>
            <h6 style="width: 120px">Ngày đặt</h6>
            <h6 style="width: 120px">Ngày trả</h6>
            <h6 style="width: 120px"></h6>
        </div>
        <div class="table list">
            <%for(RoomCategory rc : listRoom){%>
            <form class="item" action="/bookingController" method="post" class="bookingForm">
                <div style="display: flex; align-items: center; justify-content: space-around; padding: 20px 0; border-bottom: 1px solid rgba(0,0,0,0.3)">
                    <div style="width: 120px">
                        <%=rc.getRoom()%>
                        <input type="hidden" name="room" value="<%=rc.getRoom()%>">
                    </div>
                    <%if(rc.getStatus() == 0){%>  
                    <div style="width: 120px">
                        <input type="hidden" name="status" value="<%=rc.getStatus()%>">  
                        Trống
                    </div>
                    <%}else{%>
                    <div style="width: 120px">
                        <input type="hidden" name="status" value="<%=rc.getStatus()%>">
                        Được thuê
                    </div>
                    <%}%>
                    <div style="width: 120px">
                        <%=rc.getCategory()%>
                        <input type="hidden" name="category" value="<%=rc.getCategory()%>">
                    </div>
                    <div style="width: 120px"><input type="date" name="checkin" required></div>
                    <div style="width: 120px"><input type="date" name="checkout" required></div>
                    <%if(rc.getStatus() == 0){%>  
                    <div style="width: 120px"><input class="btn btn-primary" type="submit" value="Đặt phòng"></div>
                    <%}else{%>
                    <div style="width: 120px"><input class="btn btn-primary" type="submit" value="Đặt phòng" disabled></div>
                    <%}%>
                </div>
            </form>
            <%}%>
        </div>
        <%@include file="/pagination_table.jsp" %>
<!--        <script>
            document.querySelectorAll(".bookingForm").forEach(form => {
                form.addEventListener("submit", e => {
                    let checkinInput = form.querySelector('[name="checkin"]').value;
                    let checkoutInput = form.querySelector('[name="checkout"]').value;
                    let checkin = new Date(checkinInput);
                    let checkout = new Date(checkoutInput);
                    console.log(checkin);
                    console.log(checkout);

                    const isDayValid = (date) => {
                        const current = new Date();
                        return (date.getFullYear() === current.getFullYear() && date.getMonth() === current.getMonth() && (date.getDate() === current.getDate() || date.getDate() === current.getDate() + 1 || date.getDate() === current.getDate() + 2));
                    };

                    const isCheckoutValid = (checkin, checkout) => {
                        //let oneDay = 24 * 60 * 60 * 1000;
                        //let nextDay = new Date(checkin.getTime() + oneDay);
                        return checkout.getTime() >= checkin.getTime();
                    };

                    if (!isDayValid(checkin) || !isCheckoutValid(checkin, checkout)) {
                        e.preventDefault();
                    }
                });
            });
        </script>-->
        <c:if test="${not empty nofty}">
            <script>
            alert("${nofty}");
            </script>
        </c:if>
        
        <%@include file="footer.jsp" %>
