package com.bank.Controllers;

import com.bank.DB;
import com.bank.Models.ClientModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import javafx.scene.control.Button;

public class clientController {
    @FXML
    private TableColumn<ClientModel, String> tc_adr;

    @FXML
    private TableColumn<ClientModel, LocalDate> tc_dn;

    @FXML
    private TableColumn<ClientModel, String> tc_em;

    @FXML
    private TableColumn<ClientModel, Long> tc_id;

    @FXML
    private TableColumn<ClientModel, String> tc_np;

    @FXML
    private TableColumn<ClientModel, String> tc_tel;

    @FXML
    private TableView<ClientModel> tv_clients;
    @FXML
    private TextField tf_ci;

    @FXML
    private TextField tf_adr;

    @FXML
    private DatePicker tf_date;

    @FXML
    private TextField tf_em;

    @FXML
    private TextField tf_np;

    @FXML
    private TextField tf_tel;

    @FXML
    private Button btn_ajouter;

    @FXML
    private Label label;

    @FXML
    private Label labelid;

    @FXML
    private TextField tf_cin;

    @FXML
    private TextField tf_sel_adr;

    @FXML
    private TextField tf_sel_email;

    @FXML
    private TextField tf_sel_tel;

    ClientModel clt;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;


    @FXML
    public void load_page(ActionEvent event) {
        Connection conn;
        PreparedStatement pst;

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from clients");
            ResultSet rs = pst.executeQuery();
            tv_clients.getItems().clear();


            while (rs.next()) {
                tc_id.setCellValueFactory(new PropertyValueFactory<ClientModel, Long>("id_clt"));
                tc_dn.setCellValueFactory(new PropertyValueFactory<ClientModel, LocalDate>("date_n"));
                tc_em.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("email"));
                tc_np.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("nomPrenom"));
                tc_tel.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("tel"));
                tc_adr.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("adr"));
                ObservableList<ClientModel> data = FXCollections.observableArrayList(
                        new ClientModel(Long.parseLong(rs.getString("id_clt")),
                                rs.getString("nomPrenom"),
                                rs.getDate("date_n"),
                                rs.getString("tel"),
                                rs.getString("email"),
                                rs.getString("adr")));
                tv_clients.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("AJOUT CLIENT");
        alert.setHeaderText("Message: ");
        alert.setContentText("Veuillez confirmer!");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            this.label.setText("Pas de selection");
        } else if (option.get() == ButtonType.OK) {
            this.label.setText("Client ajouté ");
        } else if (option.get() == ButtonType.CANCEL) {
            this.label.setText("Annulé");
        } else {
            this.label.setText("-");
        }

    }


    @FXML
    public void register(javafx.scene.input.MouseEvent event) {
        clt = new ClientModel();

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date1 = Date.from(tf_date.getValue().atStartOfDay(defaultZoneId).toInstant());
        //String nomPrenom, Date date_n, String tel, String email, String adr
        clt.setId_clt(Long.parseLong(tf_ci.getText()));
        clt.setNomPrenom(tf_np.getText());
        clt.setDate_n(date1);
        clt.setTel(tf_tel.getText());
        clt.setEmail(tf_em.getText());
        clt.setAdr(tf_adr.getText());

        long timeInMilliSeconds = date1.getTime();
        java.sql.Date sqlDate1 = new java.sql.Date(timeInMilliSeconds);

        System.out.println("LocalDate is: " + tf_date.getValue());
        System.out.println("Date is: " + date1);
        System.out.println("sqlDate is: " + sqlDate1);
        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql = "INSERT INTO clients VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, clt.getId_clt());
            pstmt.setString(2, clt.getNomPrenom());
            pstmt.setDate(3, sqlDate1);
            pstmt.setString(4, clt.getTel());
            pstmt.setString(5, clt.getEmail());
            pstmt.setString(6, clt.getAdr());
            pstmt.executeUpdate();
            PreparedStatement pst;
            pst = conn.prepareStatement("select * from clients where id_clt = (select max(id_clt) from clients) ");
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println("FAILED");
            e.printStackTrace();
        }

        System.out.println("SUCCESS");

    }

    @FXML
    public void load_ligne() {
        Connection conn;
        PreparedStatement pst;
        tv_clients.getItems().clear();

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from clients where id_clt = (select max(id_clt) from clients) ");
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                tc_id.setCellValueFactory(new PropertyValueFactory<ClientModel, Long>("id_clt"));
                tc_dn.setCellValueFactory(new PropertyValueFactory<ClientModel, LocalDate>("date_n"));
                tc_em.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("email"));
                tc_np.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("nomPrenom"));
                tc_tel.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("tel"));
                tc_adr.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("adr"));
                ObservableList<ClientModel> data = FXCollections.observableArrayList(
                        new ClientModel(Long.parseLong(rs.getString("id_clt")),
                                rs.getString("nomPrenom"),
                                rs.getDate("date_n"),
                                rs.getString("tel"),
                                rs.getString("email"),
                                rs.getString("adr")));
                tv_clients.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ajouterclt(ActionEvent event) {

        Parent root = null;

        try {
            URL url = new File("src/main/resources/com/bank/Views/ajouterClient.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle("Ajouter client");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(e -> load_ligne());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteClient(ActionEvent ae){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SUPPRIMER CLIENT");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Veuillez confirmer la suppression!");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == null) {
            this.label.setText("Pas de selection");
        } else if (option.get() == ButtonType.OK) {
            this.label.setText("Client supprimé ");
        } else if (option.get() == ButtonType.CANCEL) {
            this.label.setText("Annulé");
        } else {
            this.label.setText("-");
        }
        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql="delete from clients where id_clt=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setLong(1,Long.parseLong(labelid.getText()));
            //pstmt.executeUpdate();

            if(pstmt.executeUpdate()!=0){
                label.setText("Client supprimé avec succés ");
            }else{

                label.setText("Veuillez vérifier CIN client!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    public void onTableItemSelect(MouseEvent event){
        clt = tv_clients.getSelectionModel().getSelectedItem();
        if (clt != null){
            labelid.setText(String.valueOf(clt.getId_clt()));
            tf_sel_tel.setText(clt.getTel());
            tf_sel_email.setText(clt.getEmail());
            tf_sel_adr.setText(clt.getAdr());

        }
    }

    @FXML
    private void onUpdateClt(MouseEvent event){

        Connection conn;
        PreparedStatement pst;
        clt.setId_clt(Long.parseLong(labelid.getText()));
        clt.setTel(tf_sel_tel.getText());
        clt.setEmail(tf_sel_email.getText());
        clt.setAdr(tf_sel_adr.getText());
        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql = "UPDATE clients SET tel=?,email=?, adr=?  WHERE id_clt=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clt.getTel());
            pstmt.setString(2, clt.getEmail());
            pstmt.setString(3, clt.getAdr());
            pstmt.setLong(4,clt.getId_clt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void searchClient(ActionEvent event)
    {
        Connection conn;
        PreparedStatement pst;

        Long cin = Long.parseLong(tf_cin.getText());

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("SELECT * FROM clients WHERE id_clt = ?");
            pst.setLong(1, cin);
            ResultSet rs = pst.executeQuery();
            tv_clients.getItems().clear();


            while (rs.next()) {
                tc_id.setCellValueFactory(new PropertyValueFactory<ClientModel, Long>("id_clt"));
                tc_dn.setCellValueFactory(new PropertyValueFactory<ClientModel, LocalDate>("date_n"));
                tc_em.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("email"));
                tc_np.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("nomPrenom"));
                tc_tel.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("tel"));
                tc_adr.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("adr"));
                ObservableList<ClientModel> data = FXCollections.observableArrayList(
                        new ClientModel(Long.parseLong(rs.getString("id_clt")),
                                rs.getString("nomPrenom"),
                                rs.getDate("date_n"),
                                rs.getString("tel"),
                                rs.getString("email"),
                                rs.getString("adr")));
                tv_clients.getItems().addAll(data);
            }

        } catch (SQLException ex) {
        }
    }

}

    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        load_page1();


        btn_ajouter.setOnMouseClicked((event) -> {
            try {
                URL  url1 = new File("src/main/resources/com/bank/Views/ajouterClient.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url1);
                Stage stage = new Stage();
                stage.setTitle("Ajouter client");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
                stage.setOnCloseRequest(e -> load_ligne());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }*/

