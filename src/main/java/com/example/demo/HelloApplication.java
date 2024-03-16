package com.example.demo;

import com.example.demo.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-livros-view-adm-bibliotecario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Sistema de Gerenciamento de Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static void trocaDeTela(String endereco, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(endereco));
        if (controller != null) {
            fxmlLoader.setController(controller);
        }
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene);
    }
    public static void main(String[] args) {
        launch();
    }
}