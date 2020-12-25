/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class DBContext implements DBInfo {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //load JDBC driver
            Class.forName(driverName);

            //sql user authentication mode
            conn = DriverManager.getConnection(dbURL, userDB, passDB);
            
            //windows authentication mode
//            conn = DriverManager.getConnection(dbURL + secutiry);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
        }
    }

    public static void closeConnection(Connection con, PreparedStatement ps) {
        try {
            con.close();
            ps.close();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
