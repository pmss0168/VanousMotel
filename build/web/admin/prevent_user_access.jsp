<%-- 
    Document   : prevent_user_access
    Created on : Mar 23, 2024, 12:17:38 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(user.getIsStaff() == 0 && user.getIsAdmin() == 0){
        response.sendRedirect("/home.jsp");
    }%>
