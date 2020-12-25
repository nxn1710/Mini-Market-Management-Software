/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.StockDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class StockDetailsDao {

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static void addStockDetails(StockDetails stockDetails) {
        try {
            con = DBContext.getConnection();
            String sql = "Insert into StockInOutDetail(stock_in_out_id, product_code, quantity) values (?, ?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stockDetails.getStockId());
            ps.setString(2, stockDetails.getProductCode());
            ps.setInt(3, stockDetails.getQuantity());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps);
        }
    }
    
    
    public static ArrayList<StockDetails> getStockDetails(int stockId) {
        ArrayList<StockDetails> listStockDetailses = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            String sql = "SELECT * FROM StockInOutDetail WHERE stock_in_out_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stockId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int stockDetailId = rs.getInt(1);
                int stockIds = rs.getInt(2);
                String pcode = rs.getString(3);
                int quantity = rs.getInt(4);
                listStockDetailses.add(new StockDetails(stockDetailId, stockIds, pcode,quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listStockDetailses;
    }
}
