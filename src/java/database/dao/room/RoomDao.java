/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.dao.room;

import database.DBO;
import java.sql.*;
import database.dao.DaoInterface;
import database.dao.booking.BookingDao;
import entity.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class RoomDao implements DaoInterface<Room>{

    @Override
    public List<Room> getAll() {
        List<Room> list = new ArrayList<>();
        try{
            Connection con = new DBO().getConnection();
            String sql = "select * from room order by room_number asc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Room room = new Room(rs.getInt("room_number"),rs.getInt("status"),rs.getInt("category"));
                list.add(room);
            }
        }
         catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Optional<Room> get(int id) {
        Room room = new Room();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from room where room_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                room = new Room(rs.getInt("room_number"), rs.getInt("status"), rs.getInt("category"));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.of(room);
    }

    @Override
    public int save(Room t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "insert into room(room_number, category) values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getRoom());
            ps.setInt(2, t.getCategory());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return t.getRoom();
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public boolean update(Room t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update room set room_number = ?, status = ?, category = ? where room_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getRoom());
            ps.setInt(2, t.getStatus());
            ps.setInt(3, t.getCategory());
            ps.setInt(4, t.getRoom());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean delete(Room t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "delete from room where room_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getRoom());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(int room) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "delete from room where room_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, room);
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean changeStatus(int room, int status){
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update room set status = ? where room_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, room);
            if(ps.executeUpdate() > 0){
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean editRoom(int room, int roomEdit, int category){
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update room set room_number = ?, category = ? where room_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, roomEdit);
            ps.setInt(2, category);
            ps.setInt(3, room);
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int countEmptyRoom(){
        int result = 0;
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select count(status)\n" +
                "from room\n" +
                "where status = 0;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int countBookedRoom(){
        int result = 0;
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select count(status)\n" +
                "from room\n" +
                "where status = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int countAllRoom(){
        int result = 0;
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select count(status)\n" +
                "from room;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static void main(String[] args) {
        RoomDao bd = new RoomDao();
        List<Room> list = bd.getAll();
        for (Room item : list) {
            System.out.println(item);
        }
        System.out.println(bd.countAllRoom());
        System.out.println(bd.countEmptyRoom());
        System.out.println(bd.countBookedRoom());
    }
}
