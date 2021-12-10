package com.bank.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;

    @FXML
    void home(MouseEvent event) {
        bp.setCenter(ap);

    }

    @FXML
    void clients(MouseEvent event) throws IOException{
        loadPage("clients");

    }

    @FXML
    void comptes(MouseEvent event) throws IOException {
        loadPage("comptes");


    }

    @FXML
    void transactions(MouseEvent event) throws IOException {
        loadPage("transactions");


    }

    private void loadPage(String page) throws IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Views/" + page + ".fxml"));
        }catch (IOException exception){
        }

        bp.setCenter(root);



    }


}
