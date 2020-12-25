/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.Language;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author nguye
 */
public class LanguageDAO {

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static Language getLanguage() {
        try {
            con = DBContext.getConnection();
            String sql = "Select * from [Language]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String code = rs.getString(1).trim();
                String country = rs.getString(2).trim();
                return new Language(code, country);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return null;
    }

    public static void changeLanguage(String code, String country) {
        try {
            con = DBContext.getConnection();
            String sql = "Update [Language] set code = ?, country = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, country);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBContext.closeConnection(con, ps);
        }
    }
}
