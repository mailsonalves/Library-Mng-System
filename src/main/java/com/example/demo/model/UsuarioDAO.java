package com.example.demo.model;

import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> pesquisarUsuarios();
    public void cadastrarUsuario();
    public void editarUsuario();
    public void excluirUsuario(String usuario);
}
