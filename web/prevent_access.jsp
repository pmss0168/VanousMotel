<%-- 
    Document   : prevent_url
    Created on : Mar 23, 2024, 12:01:00 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(user != null){
        if(user.getIsAdmin() == 1){
            response.sendRedirect("/admin/management.jsp");
        }else if(user.getIsStaff() == 1){
            response.sendRedirect("/admin/management.jsp");
        }
    }%>
