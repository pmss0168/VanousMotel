/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.dao.category;

import database.DBO;
import database.dao.DaoInterface;
import entity.Category;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CategoryDao implements DaoInterface<Category> {

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from category_room";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category cate = new Category(rs.getInt("id_category"), rs.getString("category_name"), rs.getLong("price_per_day"));
                list.add(cate);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Optional<Category> get(int id) {
        Category category = new Category();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from category_room where id_category = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                category = new Category(rs.getInt("id_category"), rs.getString("category_name"), rs.getLong("price_per_day"));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.of(category);
    }

    @Override
    public int save(Category t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "insert into category_room(category_name, price_per_day) values(?,?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getCate());
            ps.setLong(2, t.getPrice());
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public boolean update(Category t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update category_room set category_name = ?, price_per_day = ? where id_category = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getCate());
            ps.setLong(2, t.getPrice());
            ps.setInt(3, t.getIdcate());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Category t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "delete from category_room where id_category = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getIdcate());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(int id) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "delete from category_room where id_category = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean editCategory(int id, String category, long price){
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update category_room set category_name = ?, price_per_day = ? where id_category = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, category);
            ps.setLong(2, price);
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        CategoryDao cdi = new CategoryDao();
        for (Category c : cdi.getAll()) {
            System.out.println(c);
        }
        System.out.print(cdi.get(2).get());
        // Chuỗi chứa ngày tháng năm
        String dateString = "2023-11-04";

        // Định dạng của chuỗi ngày tháng năm
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Phân tích chuỗi để chuyển đổi thành Date
            java.util.Date parsedDate = dateFormat.parse(dateString);

            // Chuyển đổi từ java.util.Date sang java.sql.Date
            Date sqlDate = new Date(parsedDate.getTime());

            // In ra màn hình để kiểm tra
            System.out.println("Chuỗi ngày tháng năm: " + dateString);
            System.out.println("Date: " + sqlDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
