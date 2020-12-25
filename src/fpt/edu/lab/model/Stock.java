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
public class Stock {
    private int stockId;
    private String staffName;
    private LocalDateTime date;
    private String typeStock;

    public Stock() {
    }

    public Stock(int stockId, String staffName, LocalDateTime date, String typeStock) {
        this.stockId = stockId;
        this.staffName = staffName;
        this.date = date;
        this.typeStock = typeStock;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(String typeStock) {
        this.typeStock = typeStock;
    }
    
}
