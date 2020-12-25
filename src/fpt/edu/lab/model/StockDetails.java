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
public class StockDetails {
    private int stockDetailsId;
    private int stockId;
    private String productCode;
    private int quantity;

    public StockDetails() {
    }

    public StockDetails(int stockDetailsId, int stockId, String productCode, int quantity) {
        this.stockDetailsId = stockDetailsId;
        this.stockId = stockId;
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public int getStockDetailsId() {
        return stockDetailsId;
    }

    public void setStockDetailsId(int stockDetailsId) {
        this.stockDetailsId = stockDetailsId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
