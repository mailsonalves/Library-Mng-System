package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.Livro;
import com.example.demo.model.livroDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class EditarLivroController {

    private Livro livro;
    public EditarLivroController(Livro livro){
        this.livro = livro;
    }
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
    private Button btnVoltar;

    @FXML
    private Button btnSair;
    @FXML
    private Label labelAviso;


    @FXML
    void btnVoltarOnAction(ActionEvent event) throws IOException {
        LivroController livroController = new LivroController(livro);
        HelloApplication.trocaDeTela("livro-view.fxml", livroController);
    }

    @FXML
    void btnSairOnAction(ActionEvent event) {
        try {
            HelloApplication.trocaDeTela("login-view.fxml", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnCadastrarOnAction(ActionEvent event) {
        if(inputTitulo.getText().isEmpty() || inputAutor.getText().isEmpty() || inputEditora.getText().isEmpty() || inputCategoria.getText().isEmpty() || inputICBN.getText().isEmpty() || inputAno.getText().isEmpty() || inputQuantidade.getText().isEmpty() || inputLocalizacao.getText().isEmpty() || inputObs.getText().isEmpty() || inputEdicao.getText().isEmpty()){
            labelAviso.setText("Preencha todos os campos!");
        }else {
            try {
                livroDAOImpl livroDAO = new livroDAOImpl();
                livroDAO.editarLivro(parseInt(inputICBN.getText()), inputTitulo.getText(), inputAutor.getText(), inputEditora.getText(), parseInt(inputEdicao.getText()), parseInt(inputAno.getText()), inputCategoria.getText(), inputObs.getText(), parseInt(inputQuantidade.getText()), inputLocalizacao.getText());
                labelAviso.setText("Livro editado com sucesso!");
                HelloApplication.trocaDeTela("dashboard-view-adm-bibliotecario.fxml",null);

            }
            catch (Exception e){
                labelAviso.setText("Livro já cadastrado!");
            }
        }
    }




    @FXML
    void initialize() {
        inputTitulo.setText(livro.getTitulo());
        inputAutor.setText(livro.getAutor());
        inputEditora.setText(livro.getEditora());
        inputCategoria.setText(livro.getCategoria());
        inputICBN.setText(String.valueOf(livro.getIcbn()));
        inputAno.setText(String.valueOf(livro.getAno()));
        inputQuantidade.setText(String.valueOf(livro.getQuantidade()));
        inputLocalizacao.setText(livro.getLocalizacao());
        inputObs.setText(livro.getObservacao());
        inputEdicao.setText(String.valueOf(livro.getEdicao()));
        inputQuantidade.setDisable(true);
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'cadastro-livro-view.fxml'.";
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
