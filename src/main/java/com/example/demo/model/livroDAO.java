package com.example.demo.model;

import java.util.List;

public interface livroDAO {
    public List<livro> pesquisarLivros();
    public void cadastrarLivro();
    public void editarLivro();
    public void excluirLivro();
}
