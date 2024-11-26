/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Room {
    private int room;
    private int status;
    private int category;

    public Room() {
    }

    public Room(int room, int category) {
        this.room = room;
        this.category = category;
    }
    
    public Room(int room, int status, int category) {
        this.room = room;
        this.status = status;
        this.category = category;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
}
