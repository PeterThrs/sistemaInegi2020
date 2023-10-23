/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/inegi2020?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs)throws SQLException {
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    //mayor  performace
    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(Connection coon) throws SQLException {
        coon.close();
    }
    
}
