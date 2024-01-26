package com.example.demo.model;

public class Livro {
    private int icbn;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private String genero;
    private String categoria;
    private int quantidade;

    private String localizacao;
    private String observacao;

    private int edicao;

    public void setIcbn(int icbn) {
        this.icbn = icbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    public int getIcbn() {
        return icbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public String getLocalizacao() {
        return localizacao;
    }

    public String getObservacao() {
        return observacao;
    }


    public int getEdicao() {
        return edicao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    private int quantidadeDisponivel;
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }


    public Livro(int icbn, String titulo, String autor, String editora, int ano, String genero, String categoria, int quantidade, String localizacao, String observacao) {
        this.icbn = icbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.genero = genero;
        this.categoria = categoria;
        this.quantidade = quantidade;

        this.localizacao = localizacao;
        this.observacao = observacao;
    }

    public Livro() {

    }
}