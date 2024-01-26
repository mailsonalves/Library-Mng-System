package com.example.demo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class livroDAOImpl implements livroDAO {
    public List<Livro> pesquisarLivros() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Livro> livros = new ArrayList<Livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    Livro book = new Livro();
                    book.setIcbn(queryResult.getInt("icbn"));
                    book.setTitulo(queryResult.getString("titulo"));
                    book.setAutor(queryResult.getString("autor"));
                    book.setEditora(queryResult.getString("editora"));
                    book.setAno(queryResult.getInt("ano"));
                    book.setCategoria(queryResult.getString("categoria"));
                    book.setQuantidade(queryResult.getInt("quantidade"));
                    book.setLocalizacao(queryResult.getString("localizacao"));
                    book.setObservacao(queryResult.getString("observacoes"));
                    book.setEdicao(queryResult.getInt("edicao"));
                    book.setQuantidadeDisponivel(queryResult.getInt("quantidadeDisponivel"));
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

    public List<Livro> pesquisarLivrosTitulo(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Livro> livros = new ArrayList<Livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE titulo LIKE '%" + text
            + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    Livro book = new Livro();
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

    public List<Livro> pesquisarLivrosAutor(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Livro> livros = new ArrayList<Livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE autor LIKE '%" + text
                    + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    Livro book = new Livro();
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

    public List<Livro> pesquisarLivrosCategoria(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Livro> livros = new ArrayList<Livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE categoria LIKE '%" + text
                    + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    Livro book = new Livro();
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

    public List<Livro> pesquisarLivrosIcbn(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Livro> livros = new ArrayList<Livro>();
        if (connection != null) {
            String busca = "SELECT * FROM livros WHERE icbn LIKE '%" + text
                    + "%'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while (queryResult.next()) {
                    Livro book = new Livro();
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

    public void cadastrarLivro(int icbn, String titulo, String autor, String editora, int edicao, int ano, String categoria, String observacoes, int quantidade, String localizacao) {

        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        if (connection != null) {
            String insert = "INSERT INTO livros (icbn, titulo, autor, editora, edicao, ano, categoria, observacoes, quantidadeDisponivel, quantidade, localizacao) VALUES ('" + icbn + "', '"+ titulo + "', '" + autor + "', '" + editora + "', '"+ edicao + "', '" + ano + "', '"+ categoria+ "', '"+ observacoes + "', '"+ quantidade + "', '"+ quantidade + "', '"+ localizacao +"')";
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(insert);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
