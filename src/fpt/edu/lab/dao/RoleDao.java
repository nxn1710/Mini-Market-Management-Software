/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dao;

import fpt.edu.lab.dbcontext.DBContext;
import fpt.edu.lab.model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class RoleDao {

    public static ArrayList<Role> getAllRole() {
        ArrayList<Role> listRoles = new ArrayList<>();
        String sql = "select * from [Role]";
        Connection con = DBContext.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                int roleId = rs.getInt(1);
                String roleName = rs.getString(2);
                role.setRole_id(roleId);
                role.setRoleName(roleName);
                listRoles.add(role);
            }
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return listRoles;
    }
}
