/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.BillDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class BillDetailsDao {

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static void addBill(BillDetails billDetails) {
        try {
            con = DBContext.getConnection();
            String sql = "Insert into BillDetails(bill_id, product_code, price, quantity) values (?, ?,?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, billDetails.getBill_id());
            ps.setString(2, billDetails.getProduct_code());
            ps.setDouble(3, billDetails.getPrice());
            ps.setInt(4, billDetails.getQuantity());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps);
        }
    }

    public static ArrayList<BillDetails> getBillDetails(int billId) {
        ArrayList<BillDetails> listBillDetailses = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            String sql = "select * from BillDetails where bill_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, billId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int billDetailId = rs.getInt(1);
                int billIds = rs.getInt(2);
                String pcode = rs.getString(3);
                double price = rs.getDouble(4);
                int quantity = rs.getInt(5);
                listBillDetailses.add(new BillDetails(billDetailId, billIds, pcode, price, quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listBillDetailses;
    }
}
