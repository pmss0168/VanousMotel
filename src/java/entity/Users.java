/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Users {

    private String username;
    private String password;
    private String fullname;
    private String phone;
    private int isAdmin;
    private int isStaff;

    public Users(String username, String password, String fullname, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
    }

    public Users(String username, String fullname, String phone, int isAdmin, int isStaff) {
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
    }

    public Users(String username, String password, String fullname, String phone, int isAdmin, int isStaff) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
    }
    
    public Users() {
        
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(int isStaff) {
        this.isStaff = isStaff;
    }

    @Override
    public String toString() {
        return "Users{" + "fullname=" + fullname + ", username=" + username + ", password=" + password + '}';
    }
    public static void main(String[] args) {
        Users u = new Users("admin","admin","ADMIN","09120000");
        System.out.print(u.getIsAdmin() == 1);
    }
}
