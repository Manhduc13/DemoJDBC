package com.nguyenducmanh;

import com.nguyenducmanh.connection.DBConnection;
import com.nguyenducmanh.entities.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Todos";
        List<Todo> todos = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Todo todo = Todo.builder()
                        .Id(rs.getInt("Id"))
                        .Title(rs.getString("Title"))
                        .isCompleted(rs.getBoolean("IsCompleted"))
                        .build();
                todos.add(todo);
            }
            todos.forEach(todo -> System.out.println(todo.toString()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                DBConnection.close(conn);
            }
        }
    }
}