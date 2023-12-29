package com.example.demo.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() {
        var url = "jdbc:mysql://localhost:3306/biblioteca";
        var username = "root";
        var password = "";
        try {
            DriverManager.getConnection(url, username, password);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
