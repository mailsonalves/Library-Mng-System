package com.example.demo.controller;

import com.example.demo.model.livroDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class cadastroLivroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnEntrar;

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
    private TextField inputICBN;

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
        if(inputTitulo.getText().isEmpty() || inputAutor.getText().isEmpty() || inputEditora.getText().isEmpty() || inputCategoria.getText().isEmpty() || inputICBN.getText().isEmpty() || inputAno.getText().isEmpty() || inputQuantidade.getText().isEmpty() || inputLocalizacao.getText().isEmpty() || inputObs.getText().isEmpty() || inputEdicao.getText().isEmpty()){
            labelAviso.setText("Preencha todos os campos!");
        }else {
            try {
                livroDAOImpl livroDAO = new livroDAOImpl();
                livroDAO.cadastrarLivro(parseInt(inputICBN.getText()), inputTitulo.getText(), inputAutor.getText(), inputEditora.getText(), parseInt(inputEdicao.getText()), parseInt(inputAno.getText()), inputCategoria.getText(), inputObs.getText(), parseInt(inputQuantidade.getText()), inputLocalizacao.getText());
                labelAviso.setText("Livro cadastrado com sucesso!");
                inputTitulo.setText("");
                inputAutor.setText("");
                inputEditora.setText("");
                inputCategoria.setText("");
                inputICBN.setText("");
                inputAno.setText("");
                inputQuantidade.setText("");
                inputLocalizacao.setText("");
                inputObs.setText("");
                inputEdicao.setText("");

            }
            catch (Exception e){
                labelAviso.setText("Livro já cadastrado!");
            }
        }
    }




    @FXML
    void initialize() {
        assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert btnUsuarios != null : "fx:id=\"btnUsuarios\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert iconUsers != null : "fx:id=\"iconUsers\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert iconbook != null : "fx:id=\"iconbook\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputAno != null : "fx:id=\"inputAno\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputAutor != null : "fx:id=\"inputAutor\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputCategoria != null : "fx:id=\"inputCategoria\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputEdicao != null : "fx:id=\"inputEdicao\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputEditora != null : "fx:id=\"inputEditora\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputICBN != null : "fx:id=\"inputICBN\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputLocalizacao != null : "fx:id=\"inputLocalizacao\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputObs != null : "fx:id=\"inputObs\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputQuantidade != null : "fx:id=\"inputQuantidade\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert inputTitulo != null : "fx:id=\"inputTitulo\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
        assert labelAviso != null : "fx:id=\"labelAviso\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";

    }

}
