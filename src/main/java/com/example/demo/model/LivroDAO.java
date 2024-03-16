package com.example.demo.model;

import java.util.List;

public interface LivroDAO {
    public List<Livro> pesquisarLivros();
    public void cadastrarLivro();
    public void editarLivro(int i, String text, String inputAutorText, String inputEditoraText, int parseInt, int anInt, String inputCategoriaText, String inputObsText, int parsed, String inputLocalizacaoText);
    public void excluirLivro(int icbn);
}
