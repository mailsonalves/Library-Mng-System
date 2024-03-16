package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.LivroDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class CadastroLivroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnMenuLivros;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private FontAwesomeIconView iconUsers;

    @FXML
    private FontAwesomeIconView iconbook;

    @FXML
    private TextField inputAno;

    @FXML
    private TextField inputAutor;

    @FXML
    private TextField inputCategoria;

    @FXML
    private TextField inputEdicao;

    @FXML
    private TextField inputEditora;


    @FXML
    private TextField inputISBN;


    @FXML
    private TextField inputLocalizacao;

    @FXML
    private TextField inputObs;

    @FXML
    private TextField inputQuantidade;

    @FXML
    private TextField inputTitulo;

    @FXML
    private Label labelAviso;




    @FXML
    void btnCadastrarOnAction(ActionEvent event) {

        try {
            parseInt(inputAno.getText());
            parseInt(inputEdicao.getText());
            parseInt(inputISBN.getText());
            parseInt(inputQuantidade.getText());
        }
        catch (Exception e){
            labelAviso.setText("Preencha os campos corretamente!");
            inputISBN.setStyle("-fx-border-color: #FF0000;");
            inputQuantidade.setStyle("-fx-border-color: #FF0000;");
            inputAno.setStyle("-fx-border-color: #FF0000;");
            inputEdicao.setStyle("-fx-border-color: #FF0000;");
            return;
        }
        if(inputTitulo.getText().isEmpty() || inputAutor.getText().isEmpty() || inputEditora.getText().isEmpty() || inputCategoria.getText().isEmpty() || inputISBN.getText().isEmpty() || inputAno.getText().isEmpty() || inputQuantidade.getText().isEmpty() || inputLocalizacao.getText().isEmpty() || inputObs.getText().isEmpty() || inputEdicao.getText().isEmpty()){
            labelAviso.setText("Preencha todos os campos!");
        }


        else {
            try {
                LivroDAOImpl livroDAO = new LivroDAOImpl();
                livroDAO.cadastrarLivro(parseInt(inputISBN.getText()), inputTitulo.getText(), inputAutor.getText(), inputEditora.getText(), parseInt(inputEdicao.getText()), parseInt(inputAno.getText()), inputCategoria.getText(), inputObs.getText(), parseInt(inputQuantidade.getText()), inputLocalizacao.getText());
                labelAviso.setText("Livro cadastrado com sucesso!");

                inputTitulo.setText("");
                inputAutor.setText("");
                inputEditora.setText("");
                inputCategoria.setText("");
                inputISBN.setText("");
                inputAno.setText("");
                inputQuantidade.setText("");
                inputLocalizacao.setText("");
                inputObs.setText("");
                inputEdicao.setText("");
                inputISBN.setStyle("-fx-border-color: none;");
                inputQuantidade.setStyle("-fx-border-color: none;");
                inputAno.setStyle("-fx-border-color: none");
                inputEdicao.setStyle("-fx-border-color: none");

            }
            catch (Exception e){
                labelAviso.setText("Livro já cadastrado!");
            }
        }

    }
    @FXML
    void btnSairOnAction(ActionEvent event) throws IOException {

        HelloApplication.trocaDeTela("login-view.fxml", null);
    }

    @FXML
    void btnMenuLivrosOnAction(ActionEvent event) {

    }


    @FXML
    void initialize() {
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
        assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert btnUsuarios != null : "fx:id=\"btnUsuarios\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert iconUsers != null : "fx:id=\"iconUsers\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert iconbook != null : "fx:id=\"iconbook\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputAno != null : "fx:id=\"inputAno\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputAutor != null : "fx:id=\"inputAutor\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputCategoria != null : "fx:id=\"inputCategoria\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputEdicao != null : "fx:id=\"inputEdicao\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputEditora != null : "fx:id=\"inputEditora\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputISBN != null : "fx:id=\"inputisbn\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputLocalizacao != null : "fx:id=\"inputLocalizacao\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputObs != null : "fx:id=\"inputObs\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputQuantidade != null : "fx:id=\"inputQuantidade\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputTitulo != null : "fx:id=\"inputTitulo\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert labelAviso != null : "fx:id=\"labelAviso\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";

    }

}
