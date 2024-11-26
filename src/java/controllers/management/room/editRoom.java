/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.management.room;

import database.dao.category.CategoryDao;
import database.dao.room.RoomDao;
import entity.Category;
import entity.Room;
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
@WebServlet(name = "editRoom", urlPatterns = {"/editRoom"})
public class editRoom extends HttpServlet {

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
        int room = Integer.parseInt(request.getParameter("room"));
        int roomEdit = Integer.parseInt(request.getParameter("roomEdit"));
        int category = Integer.parseInt(request.getParameter("category"));
        RoomDao rd = new RoomDao();
        CategoryDao cd = new CategoryDao();
        boolean flag = false;
        for(Category c : cd.getAll()){
            if(c.getIdcate() == category){
                flag = true;
                break;
            }
        }
        if(flag == true){
            if(rd.editRoom(room,roomEdit,category)){
                request.setAttribute("nofty", "Sửa phòng thành công");
                request.getRequestDispatcher("/admin/room_management.jsp").forward(request, response);
            }
            else{
                request.setAttribute("nofty", "Sửa phòng thất bại");
                request.getRequestDispatcher("/admin/room_management.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("nofty", "Loại phòng không tồn tại");
            request.getRequestDispatcher("/admin/room_management.jsp").forward(request, response);
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
