package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.LivroDAOImpl;
import com.example.demo.model.UsuarioDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static java.lang.Integer.parseInt;

public class CadastroUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnMenuLivros;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private FontAwesomeIconView iconUsers;

    @FXML
    private FontAwesomeIconView iconbook;

    @FXML
    private TextField inputBairro;

    @FXML
    private TextField inputCPF;

    @FXML
    private TextField inputCidade;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputEndereço;

    @FXML
    private TextField inputEstado;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputSenha;

    @FXML
    private TextField inputTelefone;

    @FXML
    private Label labelAviso;

    @FXML
    private TextField inputUsuario;

    @FXML
    private ChoiceBox<String> labelCargo;

    @FXML
    void btnCadastrarOnAction(ActionEvent event) {

        if(inputNome.getText().isEmpty() || labelCargo.getValue()==null || inputUsuario.getText().isEmpty() || inputCPF.getText().isEmpty() || inputEmail.getText().isEmpty() || inputSenha.getText().isEmpty() || inputEndereço.getText().isEmpty() || inputBairro.getText().isEmpty() || inputCidade.getText().isEmpty() || inputEstado.getText().isEmpty() || inputTelefone.getText().isEmpty()){
            labelAviso.setText("Preencha todos os campos!");
        }

        else {
            try {
                UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
                usuarioDAO.cadastrarUsuario(inputNome.getText(), inputCPF.getText(), inputEmail.getText(), inputUsuario.getText(), inputSenha.getText(), inputEndereço.getText(), inputBairro.getText(), inputCidade.getText(), inputEstado.getText(), inputTelefone.getText(), labelCargo.getValue());
                labelAviso.setText("Usuário cadastrado com sucesso!");

                inputNome.setText("");
                inputCPF.setText("");
                inputEmail.setText("");
                inputSenha.setText("");
                inputEndereço.setText("");
                inputBairro.setText("");
                inputCidade.setText("");
                inputEstado.setText("");
                inputTelefone.setText("");
                labelCargo.setValue("");
                inputUsuario.setText("");
            }
            catch (Exception e){
                labelAviso.setText("Usuário já cadastrado!");
            }
        }

    }

    @FXML
    void btnMenuLivrosOnAction(ActionEvent event) {

    }

    @FXML
    void btnSairOnAction(ActionEvent event) throws IOException {

        HelloApplication.trocaDeTela("login-view.fxml", null);
    }

    @FXML
    void initialize() {

        String [] cargos = {"Leitor", "Bibliotecário", "Administrador"};
        labelCargo.getItems().addAll(FXCollections.observableArrayList(cargos));
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

        assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert btnMenuLivros != null : "fx:id=\"btnMenuLivros\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert btnUsuarios != null : "fx:id=\"btnUsuarios\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert iconUsers != null : "fx:id=\"iconUsers\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert iconbook != null : "fx:id=\"iconbook\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputBairro != null : "fx:id=\"inputBairro\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputCPF != null : "fx:id=\"inputCPF\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputCidade != null : "fx:id=\"inputCidade\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputEmail != null : "fx:id=\"inputEmail\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputEndereço != null : "fx:id=\"inputEndereço\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputEstado != null : "fx:id=\"inputEstado\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputNome != null : "fx:id=\"inputNome\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputSenha != null : "fx:id=\"inputSenha\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert inputTelefone != null : "fx:id=\"inputTelefone\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";
        assert labelAviso != null : "fx:id=\"labelAviso\" was not injected: check your FXML file 'cadastro-usuario-view.fxml'.";

    }

}
