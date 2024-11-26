/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Booking {
    private int id;
    private String user;
    private int room;
    private Date checkin;
    private Date checkout;
    private long price;
    private int isCancel;
    private int isSuccess;
    private int isConfirm;

    public Booking() {
    }

    public Booking(String user, int room, Date checkin, Date checkout, long price) {
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.price = price;
    }
    
    public Booking(int id, String user, int room, Date checkin, Date checkout, long price) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.price = price;
    }

    public Booking(int id, String user, int room, Date checkin, Date checkout, long price, int isCancel, int isSuccess) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.price = price;
        this.isCancel = isCancel;
        this.isSuccess = isSuccess;
    }

    public Booking(int id, String user, int room, Date checkin, Date checkout, long price, int isCancel, int isSuccess, int isConfirm) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.price = price;
        this.isCancel = isCancel;
        this.isSuccess = isSuccess;
        this.isConfirm = isConfirm;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(int isConfirm) {
        this.isConfirm = isConfirm;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", user=" + user + ", room=" + room + ", checkin=" + checkin + ", checkout=" + checkout + ", price=" + price + ", isCancel = " + isCancel +", isSuccess = " + isSuccess+ '}';
    }
    
}
