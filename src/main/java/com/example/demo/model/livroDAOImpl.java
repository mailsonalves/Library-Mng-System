package com.example.demo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class livroDAOImpl implements livroDAO {
    public List<livro> pesquisarLivros() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<livro> livros = new ArrayList<livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    livro book = new livro();
                    book.setIcbn(queryResult.getInt("icbn"));
                    book.setTitulo(queryResult.getString("titulo"));
                    book.setAutor(queryResult.getString("autor"));
                    book.setEditora(queryResult.getString("editora"));
                    book.setAno(queryResult.getInt("ano"));
                    book.setCategoria(queryResult.getString("categoria"));
                    book.setQuantidade(queryResult.getInt("quantidade"));
                    book.setLocalizacao(queryResult.getString("localizacao"));
                    book.setObservacao(queryResult.getString("observacoes"));
                    livros.add(book);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
        return livros;
    }
    public void cadastrarLivro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editarLivro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void excluirLivro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<livro> pesquisarLivrosTitulo(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<livro> livros = new ArrayList<livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE titulo LIKE '%" + text
            + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    livro book = new livro();
                    book.setIcbn(queryResult.getInt("icbn"));
                    book.setTitulo(queryResult.getString("titulo"));
                    book.setAutor(queryResult.getString("autor"));
                    book.setEditora(queryResult.getString("editora"));
                    book.setAno(queryResult.getInt("ano"));
                    book.setCategoria(queryResult.getString("categoria"));
                    book.setQuantidade(queryResult.getInt("quantidade"));
                    book.setLocalizacao(queryResult.getString("localizacao"));
                    book.setObservacao(queryResult.getString("observacoes"));
                    livros.add(book);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
        return livros;
    }

    public List<livro> pesquisarLivrosAutor(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<livro> livros = new ArrayList<livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE autor LIKE '%" + text
                    + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    livro book = new livro();
                    book.setIcbn(queryResult.getInt("icbn"));
                    book.setTitulo(queryResult.getString("titulo"));
                    book.setAutor(queryResult.getString("autor"));
                    book.setEditora(queryResult.getString("editora"));
                    book.setAno(queryResult.getInt("ano"));
                    book.setCategoria(queryResult.getString("categoria"));
                    book.setQuantidade(queryResult.getInt("quantidade"));
                    book.setLocalizacao(queryResult.getString("localizacao"));
                    book.setObservacao(queryResult.getString("observacoes"));
                    livros.add(book);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
        return livros;
    }

    public List<livro> pesquisarLivrosCategoria(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<livro> livros = new ArrayList<livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE categoria LIKE '%" + text
                    + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    livro book = new livro();
                    book.setIcbn(queryResult.getInt("icbn"));
                    book.setTitulo(queryResult.getString("titulo"));
                    book.setAutor(queryResult.getString("autor"));
                    book.setEditora(queryResult.getString("editora"));
                    book.setAno(queryResult.getInt("ano"));
                    book.setCategoria(queryResult.getString("categoria"));
                    book.setQuantidade(queryResult.getInt("quantidade"));
                    book.setLocalizacao(queryResult.getString("localizacao"));
                    book.setObservacao(queryResult.getString("observacoes"));
                    livros.add(book);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
        return livros;
    }

    public List<livro> pesquisarLivrosIcbn(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<livro> livros = new ArrayList<livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE icbn LIKE '%" + text
                    + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    livro book = new livro();
                    book.setIcbn(queryResult.getInt("icbn"));
                    book.setTitulo(queryResult.getString("titulo"));
                    book.setAutor(queryResult.getString("autor"));
                    book.setEditora(queryResult.getString("editora"));
                    book.setAno(queryResult.getInt("ano"));
                    book.setCategoria(queryResult.getString("categoria"));
                    book.setQuantidade(queryResult.getInt("quantidade"));
                    book.setLocalizacao(queryResult.getString("localizacao"));
                    book.setObservacao(queryResult.getString("observacoes"));
                    livros.add(book);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
        return livros;
    }
}
