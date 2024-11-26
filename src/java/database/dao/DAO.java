/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.dao;

import database.DBO;
import java.sql.*;
import java.util.List;
import entity.RoomCategory;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<RoomCategory> getAllRoom(){
        List<RoomCategory> listRoom = new ArrayList<>();
        String sql = "SELECT room_number, status, category_name, price_per_day FROM room r join category_room cr on r.category = cr.id_category  order by room_number asc;";
        try {
            con = new DBO().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomCategory room = new RoomCategory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getLong(4));
                listRoom.add(room);
            }
        } catch (Exception e) {

        }
        return listRoom;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<RoomCategory> list = dao.getAllRoom();
        for(RoomCategory r : list){
            System.out.println(r.toString());
            
        }

    }
}
