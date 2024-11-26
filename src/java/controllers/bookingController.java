/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import database.dao.DAO;
import database.dao.booking.BookingDao;
import database.dao.room.RoomDao;
import entity.Booking;
import entity.RoomCategory;
import entity.Users;
import entity.Util;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "bookingController", urlPatterns = {"/bookingController"})
public class bookingController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if(!Util.checkSession(session)){
            response.sendRedirect("/");
        }
        Users user = (Users) session.getAttribute("account");
        DAO dao = new DAO();
        List<RoomCategory> listRC = dao.getAllRoom();
        BookingDao bd = new BookingDao();
        RoomDao rd = new RoomDao();
        List<Booking> listBK = bd.getAll();
        boolean flag = true;
        for(Booking b : listBK){
            if(user.getUsername().equals(b.getUser()) && b.getIsCancel() == 0 && b.getIsSuccess() == 0 && user.getIsStaff() == 0 && user.getIsAdmin() == 0){
                flag = false;
                request.setAttribute("nofty", "Bạn không thể đặt nhiều hơn một phòng");
                request.getRequestDispatcher("/booking.jsp").forward(request, response);
                break;
            }
        }
        if(flag == true){
            try (PrintWriter out = response.getWriter()) {
                String roompara = request.getParameter("room");
                String statuspara = request.getParameter("status");
                String checkinpara = request.getParameter("checkin");
                String checkoutpara = request.getParameter("checkout");
                int room = Integer.parseInt(roompara);
                int status = Integer.parseInt(statuspara);

                //Xu ly ngay thang nam
                java.util.Date parseCheckin = Util.formatDate(checkinpara);
                java.util.Date parseCheckout = Util.formatDate(checkoutpara);
                java.sql.Date checkin = new java.sql.Date(parseCheckin.getTime());
                java.sql.Date checkout = new java.sql.Date(parseCheckout.getTime());
                long oneday = (24 * 60 * 60 * 1000);
                long daysBetween = (checkout.getTime() - checkin.getTime() + oneday) / oneday;
                if (status == 1) {
                    request.setAttribute("nofty", "Phòng đã dược thuê");
                    request.getRequestDispatcher("/booking.jsp").forward(request, response);
                } else {
                    if(!Util.isDayValid(checkin) || !Util.isCheckoutValid(checkin, checkout)){
                        request.setAttribute("nofty", "Ngày chọn không chính xác");
                        request.getRequestDispatcher("/booking.jsp").forward(request, response);
                    }else{
                        long price = 0;
                        for (RoomCategory rc : listRC) {
                            if (rc.getRoom() == room) {
                                price = rc.getDayPrice();
                                break;
                            }
                        }
                        long totalprice = (long) price * daysBetween;
                        Booking booking = new Booking(user.getUsername(), room, checkin, checkout, totalprice);
                        if (bd.save(booking) != -1) {
                            if (rd.changeStatus(booking.getRoom(), 1) == true) {
                                request.setAttribute("nofty", "Thuê phòng thành công");
                                request.getRequestDispatcher("/booking.jsp").forward(request, response);
                            }
                        } else {
                            request.getRequestDispatcher("/booking.jsp").forward(request, response);
                        }
                    }
                }
            }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(bookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(bookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
