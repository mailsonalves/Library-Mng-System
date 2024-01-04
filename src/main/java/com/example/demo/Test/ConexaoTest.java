package com.example.demo.Test;

import com.example.demo.model.Conexao;

import java.sql.Connection;

public class ConexaoTest {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
    }
}
