/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class WareHouseDao {

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static int quantityProductInStock(String productcode) {
        String sql = "SELECT quantity from warehouse where product_code = ?";
        con = DBContext.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, productcode);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return -1;
    }
}
