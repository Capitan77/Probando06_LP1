package com.cibertec.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//establecemos la conexion con SQL
public class DBConnection {

    private static final String URL = "jdbc:sqlserver://localhost:1434;database=S06_LP1;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "sql";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
