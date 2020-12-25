package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class ProductDao {

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static ArrayList<Product> getAllProduct() {
        ArrayList<Product> listProducts = new ArrayList<>();
        String sql = "select product_code, product_name, [description], price, quantity, Category.category_name "
                + "from [Product] Inner Join Category on Category.category_id = [Product].category_id";
        con = DBContext.getConnection();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String productCode = rs.getString(1).trim();
                String productName = rs.getString(2).trim();
                String description = rs.getString(3).trim();
                double price = rs.getDouble(4);
                int quantity = rs.getInt(5);
                String categoryName = rs.getString(6).trim();
                listProducts.add(new Product(productCode, productName, description, price, quantity, categoryName));
            }
        } catch (Exception e) {
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listProducts;
    }

    public static void addProduct(Product product, int categoryId) {
        try {
            con = DBContext.getConnection();
            String sql = "Insert into [Product](product_code,product_name,[description],price,quantity,category_id)"
                    + " values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getProduct_code());
            ps.setString(2, product.getProduct_name());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, categoryId);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
    }

    public static void updateProduct(String productCode, Product product, int categoryId) {
        try {
            con = DBContext.getConnection();
            String sql = " Update [Product] set product_code=?, product_name=?, [description]=?, price=?"
                    + ", quantity=?, category_id=? where product_code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getProduct_code());
            ps.setString(2, product.getProduct_name());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, categoryId);
            ps.setString(7, productCode);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
    }

    public static String getProductName(String productCode) {
        try {
            con = DBContext.getConnection();
            String sql = " select product_name from product where product_code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                return name;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return null;
    }

    public static void deleteProduct(String product_code) {
        try {
            con = DBContext.getConnection();
            String sql = "Delete from [Product] where product_code = '" + product_code + "'";
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
    }

    public static ArrayList<Product> getListByID(int categoryId) {
        ArrayList<Product> listProducts = new ArrayList<>();
        String sql = "select product_code, product_name, [description], price, quantity, Category.category_name "
                + "from [Product] Inner Join Category on Category.category_id = [Product].category_id where [Product].category_id = ?";
        con = DBContext.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String productCode = rs.getString(1).trim();
                String productName = rs.getString(2).trim();
                String description = rs.getString(3).trim();
                double price = rs.getDouble(4);
                int quantity = rs.getInt(5);
                String categoryName = rs.getString(6).trim();
                listProducts.add(new Product(productCode, productName, description, price, quantity, categoryName));
            }
        } catch (Exception e) {
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listProducts;
    }

    public static ArrayList<Product> searchProduct(String keyword) {
        ArrayList<Product> listProducts = new ArrayList<>();
        String sql = "select product_code, product_name, [description], price, quantity, Category.category_name "
                + "from [Product] Inner Join Category on Category.category_id = [Product].category_id"
                + " where [Product].product_name like ? or [Product].product_code like ?";
        con = DBContext.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String productCode = rs.getString(1).trim();
                String productName = rs.getString(2).trim();
                String description = rs.getString(3).trim();
                double price = rs.getDouble(4);
                int quantity = rs.getInt(5);
                String categoryName = rs.getString(6).trim();
                listProducts.add(new Product(productCode, productName, description, price, quantity, categoryName));
            }
        } catch (Exception e) {
        } finally {
            DBContext.closeConnection(con, ps, rs);
        }
        return listProducts;
    }
}
