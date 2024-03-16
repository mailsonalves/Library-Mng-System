package com.example.demo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO{
    @Override
    public List<Usuario> pesquisarUsuarios() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Usuario> usuarios= new ArrayList<Usuario>();
        if(connection != null){
            String busca = "SELECT * FROM usuarios";
            try{
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while(queryResult.next()){
                    Usuario user = new Usuario();
                    user.setUsuario(queryResult.getString("usuario"));
                    user.setNome(queryResult.getString("nome"));
                    user.setEmail(queryResult.getString("email"));
                    user.setSenha(queryResult.getString("senha"));
                    user.setCpf(queryResult.getString("cpf"));
                    user.setEndereco(queryResult.getString("endereco"));
                    user.setCidade(queryResult.getString("cidade"));
                    user.setBairro(queryResult.getString("bairro"));
                    user.setEstado(queryResult.getString("estado"));
                    user.setTelefone(queryResult.getString("telefone"));
                    if(queryResult.getInt("userType") == 1)
                        user.setCargo("Administrador");
                    else if (queryResult.getInt("userType") == 2)
                        user.setCargo("Bibliotecário");
                    else
                        user.setCargo("Leitor");

                    usuarios.add(user);
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return usuarios;
    }

    @Override
    public void cadastrarUsuario() {

    }

    @Override
    public void editarUsuario() {

    }

    @Override
    public void excluirUsuario(String usuario) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        if(connection != null){
            String busca = "DELETE FROM usuarios WHERE usuario = '" + usuario + "'";
            try{
                Statement statement = connection.createStatement();
                statement.executeUpdate(busca);

            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<Usuario> pesquisarUsuariosLeitor(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Usuario> usuarios= new ArrayList<Usuario>();
        if(connection != null){
            String busca = "SELECT * FROM usuarios WHERE nome LIKE '%" + text + "%' AND userType = '3'";
            try{
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while(queryResult.next()){
                    Usuario user = new Usuario();
                    user.setUsuario(queryResult.getString("usuario"));
                    user.setNome(queryResult.getString("nome"));
                    user.setEmail(queryResult.getString("email"));
                    user.setSenha(queryResult.getString("senha"));
                    user.setCpf(queryResult.getString("cpf"));
                    user.setEndereco(queryResult.getString("endereco"));
                    user.setCidade(queryResult.getString("cidade"));
                    user.setEstado(queryResult.getString("estado"));
                    usuarios.add(user);
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return usuarios;
    }

    public List<Usuario> pesquisarUsuariosBibliotecario(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Usuario> usuarios= new ArrayList<Usuario>();
        if(connection != null){
            String busca = "SELECT * FROM usuarios WHERE nome LIKE '%" + text + "%' AND userType = '2'";
            try{
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while(queryResult.next()){
                    Usuario user = new Usuario();
                    user.setUsuario(queryResult.getString("usuario"));
                    user.setNome(queryResult.getString("nome"));
                    user.setEmail(queryResult.getString("email"));
                    user.setSenha(queryResult.getString("senha"));
                    user.setCpf(queryResult.getString("cpf"));
                    user.setEndereco(queryResult.getString("endereco"));
                    user.setCidade(queryResult.getString("cidade"));
                    user.setEstado(queryResult.getString("estado"));
                    usuarios.add(user);
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return usuarios;
    }

    public List<Usuario> pesquisarUsuariosADM(String text) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        List<Usuario> usuarios= new ArrayList<Usuario>();
        if(connection != null){
            String busca = "SELECT * FROM usuarios WHERE nome LIKE '%" + text + "%' AND userType = '1'";
            try{
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(busca);
                while(queryResult.next()){
                    Usuario user = new Usuario();
                    user.setUsuario(queryResult.getString("usuario"));
                    user.setNome(queryResult.getString("nome"));
                    user.setEmail(queryResult.getString("email"));
                    user.setSenha(queryResult.getString("senha"));
                    user.setCpf(queryResult.getString("cpf"));
                    user.setEndereco(queryResult.getString("endereco"));
                    user.setCidade(queryResult.getString("cidade"));
                    user.setEstado(queryResult.getString("estado"));
                    usuarios.add(user);
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return usuarios;
    }

    public void cadastrarUsuario(String nome, String cpf, String email, String usuario, String senha, String endereco, String bairro, String cidade, String estado, String telefone, String cargo) {

        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        int cargoInt = 0;
        if(cargo.equals("Leitor"))
            cargoInt = 3;
        else if(cargo.equals("Bibliotecário"))
            cargoInt = 2;
        else
            cargoInt = 1;

        if(connection != null){
            String busca = "INSERT INTO usuarios (nome, cpf, email, usuario, senha, endereco, bairro, cidade, estado, telefone, userType) VALUES ('" + nome + "', '" + cpf + "', '" + email + "', '" + usuario + "', '" + senha + "', '" + endereco + "', '" + bairro + "', '" + cidade + "', '" + estado + "', '" + telefone+ "', '" + cargoInt + "')";
            try{
                Statement statement = connection.createStatement();
                statement.executeUpdate(busca);
            }catch(SQLException e){
                System.out.printf(e.getMessage());
                throw new RuntimeException(e);
            }
        }

    }
}
