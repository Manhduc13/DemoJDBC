package com.nguyenducmanh.connection;

import java.sql.*;

public class DBConnection {
    private static final String username = "sa";
    private static final String password = "1234567890";
    private static final String connectionUrl =
            "jdbc:sqlserver://localhost:1434;" +
                    "databaseName=Todo_dev;" +
                    "encrypt=true;trustServerCertificate=true";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, username, password);
    }

    public static void close(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void close(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }
}
