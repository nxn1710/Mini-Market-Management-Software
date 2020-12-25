/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.Bill;
import java.sql.Connection;
import java.sql.Date;
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
public class BillDao {
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    
    public static ArrayList<Bill> getAllBillByMonth(int month) {
        ArrayList<Bill> listBill = new ArrayList<>();
        String sql = "SELECT * FROM Bill WHERE MONTH(order_date) = ?";
        con = DBContext.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                int billId = rs.getInt(1);
                String sellerName = rs.getString(2);
                String date = rs.getString(3);
                double price = rs.getDouble(4);
                listBill.add(new Bill(billId, sellerName, LocalDateTime.parse(date, dtf), price));
            }
        } catch (Exception e) {
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listBill;
    }
    
    public static int addBill(Bill bill) {
        int billId = -1;
        try {
            con = DBContext.getConnection();
            String sql = "Insert into Bill(sellername, order_date, total_price) values (?,?,?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, bill.getSellername());
            ps.setString(2, dtf.format(bill.getOrder_date()));
            ps.setDouble(3, bill.getTotal_price());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                billId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return billId;
    }
    
}
