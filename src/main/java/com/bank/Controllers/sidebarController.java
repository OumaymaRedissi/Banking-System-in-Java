package com.bank.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sidebarController implements Initializable {

    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;

    @FXML
    void home(MouseEvent event) {
        bp.setCenter(ap);
        loadPage("home");

    }
    @FXML
    void clients(MouseEvent event) {
        loadPage("clients");

    }

    @FXML
    void comptes(MouseEvent event) {
        loadPage("comptes");

    }

    @FXML
    void transactions(MouseEvent event) {
        loadPage("transactions");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("home");

    }
    private void loadPage(String page){

        Parent root = null;

        try {
            URL url = new File("src/main/resources/com/bank/Views/"+page+".fxml").toURI().toURL();
            root = FXMLLoader.load(url);


        } catch (IOException e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }
}
