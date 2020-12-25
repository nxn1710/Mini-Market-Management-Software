/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.model;

import java.time.LocalDateTime;

/**
 *
 * @author nguye
 */
public class Bill {
    private int bill_id;
    private String sellername;
    private LocalDateTime order_date;
    private double total_price;

    public Bill() {
    }

    public Bill(int bill_id, String sellername, LocalDateTime order_date, double total_price) {
        this.bill_id = bill_id;
        this.sellername = sellername;
        this.order_date = order_date;
        this.total_price = total_price;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    
    
}
