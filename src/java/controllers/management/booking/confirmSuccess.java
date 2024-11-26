/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.management.booking;

import database.dao.booking.BookingDao;
import database.dao.room.RoomDao;
import entity.Booking;
import entity.Util;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "confirmSuccess", urlPatterns = {"/confirmSuccess"})
public class confirmSuccess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if(!Util.checkSession(session)){
            response.sendRedirect("/");
        }
        final int isNotCancel = 0;
        final int isNotConfirm = 0;
        final int isSuccess = 1;
        final int isNotBooking = 0;
        int id = Integer.parseInt(request.getParameter("id"));
        int room = Integer.parseInt(request.getParameter("room"));
        BookingDao bd = new BookingDao();
        RoomDao rd = new RoomDao();
        Booking b = bd.get(id).get();
        if(b.getIsCancel() == 0 && b.getIsSuccess() == 0 && b.getIsConfirm() == 1){
            bd.changeStatus(id, isNotCancel, isSuccess, isNotConfirm);
            rd.changeStatus(room, isNotBooking);
            request.setAttribute("nofty", "Xác nhận hoàn tất");
            request.getRequestDispatcher("/admin/booking_management.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/admin/booking_management.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
