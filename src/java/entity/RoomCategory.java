/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class RoomCategory {
    private int room;
    private int status;
    private String category;
    private long dayPrice;

    public RoomCategory() {
    }

    public RoomCategory(int room, int status, String category, long dayPrice) {
        this.room = room;
        this.status = status;
        this.category = category;
        this.dayPrice = dayPrice;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(long dayPrice) {
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "Rooms{" + "room=" + room + ", status=" + status + ", category=" + category + ", dayPrice=" + dayPrice + '}';
    }
    
}
