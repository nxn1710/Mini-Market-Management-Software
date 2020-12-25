/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.dbcontext;

/**
 *
 * @author nguye
 */
public interface DBInfo {
    public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String dbName = "MiniMart";
    public static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName + ";";
    public static final String userDB = "sa";
    public static final String passDB = "sa";
    public static final String secutiry = "integratedSecurity=true;";
}
