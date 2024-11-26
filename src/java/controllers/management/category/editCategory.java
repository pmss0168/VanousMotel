/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.management.category;

import database.dao.category.CategoryDao;
import entity.Category;
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
@WebServlet(name = "editCategory", urlPatterns = {"/editCategory"})
public class editCategory extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            CategoryDao cd = new CategoryDao();
            String category = request.getParameter("category");
            int id = Integer.parseInt(request.getParameter("id"));
            long price = Long.parseLong(request.getParameter("price"));
            boolean flag = false;
            for(Category c : cd.getAll()){
                if(c.getIdcate() == id){
                    flag = true;
                    break;
                }
            }
            if(price >= 10000 && flag == true){
                if(cd.editCategory(id,category,price)){
                    request.setAttribute("nofty", "Sửa loại phòng thành công");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("nofty", "Sửa loại phòng thất bại");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
                }
            }
            else{
                if(flag == false){
                    request.setAttribute("nofty", "Loại phòng không tồn tại");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
                }
                else if(price < 10000){
                    request.setAttribute("nofty", "Giá phải tối thiểu là 10,000");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
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
