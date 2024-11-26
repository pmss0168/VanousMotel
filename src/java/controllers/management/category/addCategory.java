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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "addCategory", urlPatterns = {"/addCategory"})
public class addCategory extends HttpServlet {

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
            throws ServletException, IOException, NumberFormatException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if(!Util.checkSession(session)){
            response.sendRedirect("/");
        }
        try (PrintWriter out = response.getWriter()) {
            CategoryDao cd = new CategoryDao();
            String cate = request.getParameter("name");
            String pricepara = request.getParameter("price");
            long price = (long) Long.parseLong(pricepara);
            boolean flag = true;
            for(Category c : cd.getAll()){
                if(c.getCate().equals(cate)){
                    flag = false;
                    break;
                }
            }
            if(price >= 10000 && flag == true){
                Category category = new Category(cate, price);
                int checkSave = cd.save(category);
                if(checkSave != -1){
                    request.setAttribute("nofty", "Thêm loại phòng vào thành công");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("nofty", "Loại phòng đã tồn tại");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
                }
            }
            else{
                if(price < 10000){
                    request.setAttribute("nofty", "Giá phải tối thiểu là 10,000");
                    request.getRequestDispatcher("/admin/category_management.jsp").forward(request, response);
                }
                else if(flag == false && price >= 10000){
                    request.setAttribute("nofty", "Loại phòng đã tồn tại");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(addCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addCategory.class.getName()).log(Level.SEVERE, null, ex);
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
