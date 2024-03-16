package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.Livro;
import com.example.demo.model.LivroDAO;
import com.example.demo.model.LivroDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import static com.example.demo.HelloApplication.trocaDeTela;

public class LivroController {

    private Livro livro;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarLivro;

    @FXML
    private Button btnExcluirLivro;

    @FXML
    private FontAwesomeIconView iconUsers;

    @FXML
    private FontAwesomeIconView iconbook;

    @FXML
    private Label labelAno;

    @FXML
    private Text labelAutor;

    @FXML
    private Label labelAviso;

    @FXML
    private Label labelCategoria;

    @FXML
    private Label labelEdicao;

    @FXML
    private Label labelEditora;

    @FXML
    private Label labelisbn;

    @FXML
    private Label labelLocalizacao;

    @FXML
    private Label labelObservacoes;

    @FXML
    private Label labelQuantidade;

    @FXML
    private Label labelQuantidadeDisponivel;

    @FXML
    private Text labelTitulo;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Button btnUsuarios1;




    public LivroController(Livro livro) {
        this.livro = livro;
    }

    @FXML
    void btnExcluirLivroOnAction(ActionEvent event) throws IOException {
        LivroDAOImpl livroDAO = new LivroDAOImpl();
        livroDAO.excluirLivro(livro.getisbn());
        HelloApplication.trocaDeTela("menu-livros-view-adm-bibliotecario.fxml", null);

    }
    @FXML
    void btnVoltarOnAction(ActionEvent event) throws IOException {

        HelloApplication.trocaDeTela("menu-livros-view-adm-bibliotecario.fxml", null);
    }
    @FXML
    void btnEditarLivroOnAction(ActionEvent event) throws IOException {
        EditarLivroController cotroller = new EditarLivroController(livro);
        HelloApplication.trocaDeTela("editar-livro-view.fxml", cotroller);
    }
    @FXML
    void btnSairOnAction(ActionEvent event) {
        try {
            trocaDeTela("login-view.fxml", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        labelTitulo.setText(livro.getTitulo());
        labelAutor.setText(livro.getAutor());
        labelAno.setText(String.valueOf(livro.getAno()));
        labelCategoria.setText(livro.getCategoria());
        labelEdicao.setText(String.valueOf(livro.getEdicao()));
        labelEditora.setText(livro.getEditora());
        labelisbn.setText(String.valueOf(livro.getisbn()));
        labelLocalizacao.setText(livro.getLocalizacao());
        labelObservacoes.setText(livro.getObservacao());
        labelQuantidade.setText(String.valueOf(livro.getQuantidade()));
        labelQuantidadeDisponivel.setText(String.valueOf(livro.getQuantidadeDisponivel()));


        //Colocando hover dos icones da barra lateral
        iconUsers.setOnMouseEntered(e -> {
            btnUsuarios.setStyle("-fx-background-color:#D9D9D9;");
        });
        iconUsers.setOnMouseClicked(e -> {
            try {
                HelloApplication.trocaDeTela("menu-usuario-view-adm-bibliotecario.fxml", null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iconUsers.setOnMouseExited(e -> {
            btnUsuarios.setStyle("-fx-background-color: none;");
        });
        btnUsuarios.setOnMouseEntered(e -> {
            btnUsuarios.setStyle("-fx-background-color:#D9D9D9;");
        });
        btnUsuarios.setOnMouseExited(e -> {
            btnUsuarios.setStyle("-fx-background-color: none;");
        });
        iconbook.setOnMouseClicked(e -> {
            try {
                HelloApplication.trocaDeTela("menu-livros-view-adm-bibliotecario.fxml", null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        assert btnEditarLivro != null : "fx:id=\"btnEditarLivro\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert btnExcluirLivro != null : "fx:id=\"btnExcluirLivro\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert iconUsers != null : "fx:id=\"iconUsers\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert iconbook != null : "fx:id=\"iconbook\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelAno != null : "fx:id=\"labelAno\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelAutor != null : "fx:id=\"labelAutor\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelAviso != null : "fx:id=\"labelAviso\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelCategoria != null : "fx:id=\"labelCategoria\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelEdicao != null : "fx:id=\"labelEdicao\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelEditora != null : "fx:id=\"labelEditora\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelisbn != null : "fx:id=\"labelisbn\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelLocalizacao != null : "fx:id=\"labelLocalizacao\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelObservacoes != null : "fx:id=\"labelObservacoes\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelQuantidade != null : "fx:id=\"labelQuantidade\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelQuantidadeDisponivel != null : "fx:id=\"labelQuantidadeDisponivel\" was not injected: check your FXML file 'livro-view.fxml'.";
        assert labelTitulo != null : "fx:id=\"labelTitulo\" was not injected: check your FXML file 'livro-view.fxml'.";


    }


}
