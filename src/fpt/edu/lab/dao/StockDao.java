/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class StockDao {
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    
    public static ArrayList<Stock> getAllStockByMonth(int month) {
        ArrayList<Stock> listStock = new ArrayList<>();
        String sql = "SELECT * FROM StockInOut WHERE MONTH(lastDate) = ?";
        con = DBContext.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                int stockId = rs.getInt(1);
                String staffName = rs.getString(2);
                String date = rs.getString(3);
                String typeStock = rs.getString(4);
                listStock.add(new Stock(stockId, staffName, LocalDateTime.parse(date, dtf), typeStock));
            }
        } catch (Exception e) {
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listStock;
    }
    
    public static int addStock(Stock stock) {
        int billStock = -1;
        try {
            con = DBContext.getConnection();
            String sql = "Insert into StockInOut(staffname, lastDate, in_or_out) values (?,?,?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, stock.getStaffName());
            ps.setString(2, dtf.format(stock.getDate()));
            ps.setString(3, stock.getTypeStock());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                billStock = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return billStock;
    }
}
