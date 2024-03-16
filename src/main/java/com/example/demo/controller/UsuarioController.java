package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo.HelloApplication.trocaDeTela;

public class UsuarioController {

    private Usuario usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarLivro;

    @FXML
    private Button btnExcluirLivro;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Button btnUsuarios1;

    @FXML
    private FontAwesomeIconView iconUsers;

    @FXML
    private FontAwesomeIconView iconbook;

    @FXML
    private Label labelBairro;

    @FXML
    private Text labelCargo;

    @FXML
    private Label labelCidade;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelEstado;

    @FXML
    private Text labelNome;

    @FXML
    private Label labelRua;

    @FXML
    private Label labelSituacao;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelCPF;

    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    void btnEditarUsuarioOnAction(ActionEvent event) throws IOException {
        EditarUsuarioController cotroller = new EditarUsuarioController(usuario);
        HelloApplication.trocaDeTela("editar-usuario-view.fxml", cotroller);
    }


    @FXML
    void btnExcluirUsuarioOnAction(ActionEvent event) throws IOException {
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        usuarioDAO.excluirUsuario(usuario.getUsuario());
        HelloApplication.trocaDeTela("menu-livros-view-adm-bibliotecario.fxml", null);
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
        labelNome.setText(usuario.getNome());
        labelCargo.setText(usuario.getCargo());
        labelEmail.setText(usuario.getEmail());
        labelTelefone.setText(usuario.getTelefone());
        labelRua.setText(usuario.getEndereco());
        labelBairro.setText(usuario.getBairro());
        labelCidade.setText(usuario.getCidade());
        labelEstado.setText(usuario.getEstado());
        labelCPF.setText(usuario.getCpf());
        if (usuario.getInadimplente() == 1) {
            labelSituacao.setText("Inadimplente");
        }
        else {
            labelSituacao.setText("Adimplente");
        }


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
        assert btnEditarLivro != null : "fx:id=\"btnEditarLivro\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert btnExcluirLivro != null : "fx:id=\"btnExcluirLivro\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert btnUsuarios != null : "fx:id=\"btnUsuarios\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert btnUsuarios1 != null : "fx:id=\"btnUsuarios1\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert iconUsers != null : "fx:id=\"iconUsers\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert iconbook != null : "fx:id=\"iconbook\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelBairro != null : "fx:id=\"labelBairro\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelCargo != null : "fx:id=\"labelCargo\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelCidade != null : "fx:id=\"labelCidade\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelEmail != null : "fx:id=\"labelEmail\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelEstado != null : "fx:id=\"labelEstado\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelNome != null : "fx:id=\"labelNome\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelRua != null : "fx:id=\"labelRua\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelSituacao != null : "fx:id=\"labelSituacao\" was not injected: check your FXML file 'usuario-view.fxml'.";
        assert labelTelefone != null : "fx:id=\"labelTelefone\" was not injected: check your FXML file 'usuario-view.fxml'.";


    }


}
