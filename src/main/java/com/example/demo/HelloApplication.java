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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Sistema de Gerenciamento de Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static void trocaDeTela(String endereco) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(endereco));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene);
    }
    public static void main(String[] args) {
        launch();
    }
}