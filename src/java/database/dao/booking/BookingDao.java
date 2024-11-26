/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.dao.booking;

import java.sql.*;
import database.DBO;
import entity.Booking;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.dao.DaoInterface;
import database.dao.room.RoomDao;

/**
 *
 * @author ADMIN
 */
public class BookingDao implements DaoInterface<Booking> {

    @Override
    public List<Booking> getAll() {
        List<Booking> list = new ArrayList<>();
        try {
            String sql = "select * from booking order by id_booking desc";
            Connection con = new DBO().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking(rs.getInt("id_booking"), rs.getString("user_booking"), rs.getInt("room"), rs.getDate("check_in"), rs.getDate("check_out"), rs.getLong("total_price"), rs.getInt("isCancel"), rs.getInt("isSuccess"), rs.getInt("isConfirm"));
                list.add(booking);
            }
            con.close();
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Optional<Booking> get(int id) {
        Booking booking = new Booking();
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from booking where id_booking = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                booking = new Booking(rs.getInt("id_booking"), rs.getString("user_booking"), rs.getInt("room"), rs.getDate("check_in"), rs.getDate("check_out"), rs.getLong("total_price"), rs.getInt("isCancel"), rs.getInt("isSuccess"), rs.getInt("isConfirm"));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.of(booking);
    }

    @Override
    public int save(Booking t) {
        try {
            Connection con = new DBO().getConnection();
            String sql = "insert into booking(user_booking,room,check_in,check_out,total_price) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = null;
            ps.setString(1, t.getUser());
            ps.setInt(2, t.getRoom());
            ps.setDate(3, (Date) t.getCheckin());
            ps.setDate(4, (Date) t.getCheckout());
            ps.setLong(5, t.getPrice());
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public boolean update(Booking t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update booking set id_booking = ?, user_booking = ?, room = ?, check_in = ?, check_out = ?, total_price = ?, isCancel = ?, isSuccess = ?, isConfirm where id_booking = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getUser());
            ps.setInt(2, t.getRoom());
            ps.setDate(3, (Date) t.getCheckin());
            ps.setDate(4, (Date) t.getCheckout());
            ps.setLong(5, t.getPrice());
            ps.setInt(6, t.getIsCancel());
            ps.setInt(7, t.getIsSuccess());
            ps.setInt(8, t.getIsConfirm());
            ps.setString(9, t.getUser());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Booking t) {
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "delete from booking where id_booking = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public void autoUpdateStatus() {
//        BookingDao bd = new BookingDao();
//        RoomDao rd = new RoomDao();
//        List<Booking> listBooking = bd.getAll();
//        for (Booking b : listBooking) {
//            try {
//                java.util.Date current = new java.util.Date();
//                java.util.Date checkoutDate = (java.util.Date) b.getCheckout();
//                if (current.after(checkoutDate)) {
//                    if (rd.update(b.getRoom(), 0)) {
//                        continue;
//                    }
//                }
//            } catch (Exception e) {
//            }
//        }
//    }

    public void changeStatus(int id, int isCancel, int isSuccess, int isConfirm){
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "update booking set isCancel = ?, isSuccess = ?, isConfirm = ? where id_booking = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, isCancel);
            ps.setInt(2, isSuccess);
            ps.setInt(3, isConfirm);
            ps.setInt(4, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public long totalAmount(){
        long amount = 0;
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select sum(total_price)\n" +
                "from booking\n" +
                "where isSuccess = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                amount = rs.getLong(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }
    
    public int countAllCancel(){
        int cancel = 0;
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select count(*)\n" +
                "from booking\n" +
                "where isCancel = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cancel = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cancel;
    }
    
    public int countAllSuccess(){
        int success = 0;
        try {
            Connection con = new DBO().getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select count(*)\n" +
                "from booking\n" +
                "where isSuccess = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                success = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public static void main(String[] args) {
        BookingDao bd = new BookingDao();
        List<Booking> list = bd.getAll();
        for (Booking item : list) {
            System.out.println(item);
        }
        System.out.println(bd.totalAmount());
        System.out.println(bd.countAllCancel());
        System.out.println(bd.countAllSuccess());
    }
}
