/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Category {
    private int idcate;
    private String cate;
    private long price;

    public Category() {
    }

    public Category(String cate, long price) {
        this.cate = cate;
        this.price = price;
    }

    public Category(int idcate, String cate, long price) {
        this.idcate = idcate;
        this.cate = cate;
        this.price = price;
    }

    public int getIdcate() {
        return idcate;
    }

    public void setIdcate(int idcate) {
        this.idcate = idcate;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Category{" + "idcate=" + idcate + ", cate=" + cate + ", price=" + price + '}';
    }
    
}
