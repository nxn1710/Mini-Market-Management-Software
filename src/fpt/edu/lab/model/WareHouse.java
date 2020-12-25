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
public class WareHouse {
    private String product_code;
    private int quantity;

    public WareHouse() {
    }

    public WareHouse(String product_code, int quantity) {
        this.product_code = product_code;
        this.quantity = quantity;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
