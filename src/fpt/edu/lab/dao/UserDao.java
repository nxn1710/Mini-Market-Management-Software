/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author BIA
 */
public class UserDao {

    public static ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList();
        try {
            String sql = "Select [User].username, [User].fullname, [User].[password], [Role].role_name from [User]\n"
                    + "INNER JOIN [Role] ON [User].role_id=[Role].role_id;";
            Connection conn = DBContext.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString(1).trim();
                String fullname = rs.getString(2).trim();
                String password = rs.getString(3).trim();
                String rolename = rs.getString(4).trim();
                list.add(new User(username, fullname, password, rolename));
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User loginUser(String usernameLogin, String passwordLogin) {
        User user = null;
        try {
            String sql = "   Select [User].username, [User].fullname, [User].[password], [Role].role_name from [User]\n"
                    + "INNER JOIN [Role] ON [User].role_id=[Role].role_id where [user].username = '" + usernameLogin + "' and [user].[password] = '" + passwordLogin + "';";
            Connection conn = DBContext.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString(1).trim();
                String fullname = rs.getString(2).trim();
                String password = rs.getString(3).trim();
                String rolename = rs.getString(4).trim();
                user = new User(username, fullname, password, rolename);
            }
            conn.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(User user, int role_id) {
        try {
            Connection conn;
            conn = DBContext.getConnection();
            String sql = "Insert into [User] values (?,?,?,?)";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, user.getUsername().trim());
            prs.setString(2, user.getFullname().trim());
            prs.setString(3, user.getPassword().trim());
            prs.setInt(4, role_id + 1);
            prs.execute();
            conn.close();
            System.out.println("Add successfull!");
        } catch (Exception e) {
            System.out.println("Add failed!");
            e.printStackTrace();
        }
    }

    public static void updateUser(String name, User user) {
        try {
            Connection conn;
            conn = DBContext.getConnection();
            String sql = " Update [User] set fullname =?, [password] =?, role_id =? where username = '" + name + "'";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, user.getFullname().trim());
            pre.setString(2, user.getPassword().trim());
            pre.setString(3, user.getRolename().trim());
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String name) {
        try {
            Connection conn;
            conn = DBContext.getConnection();
            String sql = "Delete from [User] where username = '" + name + "'";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isDuplicate(String username) {
        try {
            Connection con;
            con = DBContext.getConnection();
            String sql = "select * from [User] where username = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static ArrayList<User> searchByFullname(String name) {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            Connection conn;
            conn = DBContext.getConnection();
            String sql = "Select [User].username,[User].[password],[User].fullname,[Role].role_name from [User] inner join [Role] on [User].role_id = [Role].role_id where [User].fullname like '%" + name + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String fullname = rs.getString(3);
                String role_name = rs.getString(4);
                listUser.add(new User(username, fullname, password, role_name));
            }
            conn.close();
            return listUser;
        } catch (SQLException e) {
            System.out.println("Add failed!");
        }

        return null;
    }

    public static ArrayList<User> search(String name, String rolename) {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            Connection conn;
            conn = DBContext.getConnection();
            String sql = "Select [User].username,[User].[password],[User].fullname,[Role].role_name from [User] inner join [Role] on [User].role_id = [Role].role_id where [User].fullname like '%" + name + "%' and [Role].role_name = '" + rolename + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String fullname = rs.getString(3);
                String role_name = rs.getString(4);
                listUser.add(new User(username, fullname, password, role_name));
            }
            conn.close();
            return listUser;
        } catch (SQLException e) {
            System.out.println("Add failed!");
        }
        return null;
    }

    public static boolean changePassword(String passwordChange, String password, String username) {
        try {
            Connection conn;
            conn = DBContext.getConnection();
            String sql = "Update [User] set [password] = '" + passwordChange + "'  where [password] = '" + password + "' and [username] = '" + username + "'";
            PreparedStatement pre = conn.prepareStatement(sql);
            if(pre.executeUpdate() != 0){
                return true;
            }
        } catch (Exception e) {
            
        }
        return false;
    }
}
