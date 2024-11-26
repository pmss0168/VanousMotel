/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.dao.user;

import database.DBO;
import database.dao.DaoInterface;
import entity.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class UserDao implements DaoInterface<Users>{

    @Override
    public List<Users> getAll() {
        List<Users> list = new ArrayList<>();
        try{
            String sql = "select * from users";
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Users booking = new Users(rs.getString("username"),rs.getString("fullname"),rs.getString("phone"),rs.getInt("isAdmin"), rs.getInt("isStaff"));
                list.add(booking);
            }
            con.close();
        }
        catch(Exception e){
            
        }
        return list;
    }

    
    public Optional<Users> get(String name) {
        Users user = new Users();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from users where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new Users(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"), rs.getInt("isAdmin"), rs.getInt("isStaff"));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.of(user);
    }

    @Override
    public int save(Users t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "insert into users(username, password, fullname, phone) values(?,?,?,?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getFullname());
            ps.setString(4, t.getPhone());
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public boolean update(Users t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update users set username = ?, password = ?, fullname = ?, phone = ?, isAdmin = ?, isStaff = ? where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getFullname());
            ps.setString(4, t.getPhone());
            ps.setInt(5, t.getIsAdmin());
            ps.setInt(6, t.getIsStaff());
            ps.setString(7, t.getUsername());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Users t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "delete from users where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getUsername());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Optional<Users> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Users checkUserExists(String user) {
        String sql = "select * from users where username=?";
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Users checkUserExists(String user, String pass) {
        String sql = "select * from users where username=? and password=?";
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void registerHandle(String user, String pass, String name, String phone) throws Exception {
        String sql = "insert into users(username,password,fullname,phone) values(?,?,?,?)";
        Connection con = new DBO().getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.setString(3, name);
        ps.setString(4, phone);
        ps.executeUpdate();
    }

    public Users loginHandle(String user, String pass) {
        String sql = "select * from users where username = ? and password = ?";
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (Exception e) {

        }
        return null;
    }
    
    public void updateAdmin(String user, int isAdmin){
        try{
            String sql = "update users set isAdmin = ? where username = ?";
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isAdmin);
            ps.setString(2, user);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    public void updateStaff(String user, int isStaff){
        try{
            String sql = "update users set isStaff = ? where username = ?";
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isStaff);
            ps.setString(2, user);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public Users getUser(String name) {
        Users user = new Users();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from users where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new Users(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"), rs.getInt("isAdmin"), rs.getInt("isStaff"));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public void changePassword(String user, String newPassword) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update users set username = ?, password = ? where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, newPassword);
            ps.setString(3, user);
            ps.executeUpdate();
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return false;
    }
    
    public List<Users> searchUserBooking(String name) {
        List<Users> listUser = new ArrayList<>();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from users where username like ? or fullname like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                listUser.add(new Users(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"), rs.getInt("isAdmin"), rs.getInt("isStaff")));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }
}
