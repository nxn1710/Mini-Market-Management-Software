/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.model;

/**
 *
 * @author nguye
 */
public class Role {
    private int Role_id;
    private String roleName;

    public Role() {
    }

    public Role(int Role_id, String roleName) {
        this.Role_id = Role_id;
        this.roleName = roleName;
    }

    public int getRole_id() {
        return Role_id;
    }

    public void setRole_id(int Role_id) {
        this.Role_id = Role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
    
}
