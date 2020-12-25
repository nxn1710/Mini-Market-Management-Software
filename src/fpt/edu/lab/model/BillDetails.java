/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.model;

/**
 *
 * @author nguye
 */
public class BillDetails {

    private int bill_detail_id;
    private int bill_id;
    private String product_code;
    private double price;
    private int quantity;

    public BillDetails() {
    }

    public BillDetails(int bill_detail_id, int bill_id, String product_code, double price, int quantity) {
        this.bill_detail_id = bill_detail_id;
        this.bill_id = bill_id;
        this.product_code = product_code;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBill_detail_id() {
        return bill_detail_id;
    }

    public void setBill_detail_id(int bill_detail_id) {
        this.bill_detail_id = bill_detail_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
