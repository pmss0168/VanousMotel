/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Util {
    public static boolean checkSession(HttpSession session){
        Users user = (Users) session.getAttribute("account");
        return user != null;
    }
    public static Date formatDate(String date) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parseDate = formatter.parse(date);
        return parseDate;
    }
    public static String formatToVND(long price){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        return decimalFormat.format(price);
    }
    public static String rootPath(){
        return "/Project_J2EE_NhaNghi/";
    }
    public static boolean isDayValid(java.sql.Date date){
        long milis = System.currentTimeMillis();
        java.sql.Date current = new java.sql.Date(milis);
        long oneday = 24*60*60*1000;
        return (date.getYear() == current.getYear() && date.getMonth() == current.getMonth() && date.getDate() >= current.getDate()) && date.getTime() <= current.getTime() + 3*oneday;
    }
    public static boolean isCheckoutValid(java.sql.Date checkin, java.sql.Date checkout){
        long milis = System.currentTimeMillis();
        java.sql.Date current = new java.sql.Date(milis);
        return checkout.getTime() >= checkin.getTime() && checkout.getTime() >= current.getTime();
    }
    public static void main(String[] args) throws ParseException {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis()- 2*24*60*60*1000);
        java.sql.Date dateafter2d = new java.sql.Date(System.currentTimeMillis() + 2*24*60*60*1000);
        System.out.println(Util.isDayValid(date));
        System.out.println(date);
        System.out.println(Util.isCheckoutValid(date, dateafter2d));
    }
}
