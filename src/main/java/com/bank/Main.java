package com.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/sidebar.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mezgar Redissi Banking");
        stage.setScene(scene);
        stage.show();

        DB db = new DB();
        db.connect();

    }


    public static void main(String[] args) {

        launch();
    }
}