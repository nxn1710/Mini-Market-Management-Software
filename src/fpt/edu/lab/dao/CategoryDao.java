/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author truong khanh toan
 */
public class CategoryDao {

    static Connection conn;
    static PreparedStatement pre;
    static ResultSet rs;

    public static ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList();
        try {
            String sql = "Select * from Category";
            conn = DBContext.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2).trim();
                list.add(new Category(id, username));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(conn, pre, rs);
        }
        return null;
    }
    
    public static ArrayList<Category> searchCategory(String categoryName) {
        ArrayList<Category> list = new ArrayList();
        try {
            String sql = "Select * from Category where category_name like ?";
            conn = DBContext.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + categoryName + "%");
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2).trim();
                list.add(new Category(id, username));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(conn, pre, rs);
        }
        return null;
    }

    public static void addCategory(Category c) {
        try {
            conn = DBContext.getConnection();
            String sql = "Insert into Category values (?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, c.getCategoryName());
            pre.execute();
            conn.close();
            System.out.println("Successfull!");
        } catch (Exception e) {
            System.out.println("Failed!");
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(conn, pre, rs);
        }
    }

    public static void updateCategory(int id, Category c) {
        try {
            conn = DBContext.getConnection();
            String sql = " Update Category set category_name = ? where category_id = '" + id + "'";
            pre = conn.prepareStatement(sql);
            pre.setString(1, c.getCategoryName());
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(conn, pre, rs);
        }
    }

    public static void deleteCategory(int id) {
        try {
            conn = DBContext.getConnection();
            String sql = "Delete from Category where category_id = '" + id + "'";
            pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(conn, pre, rs);
        }
    }
}
