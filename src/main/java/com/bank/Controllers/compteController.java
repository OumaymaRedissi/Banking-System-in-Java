package com.bank.Controllers;

import com.bank.DB;
import com.bank.Models.ClientModel;
import com.bank.Models.CompteModel;
import com.bank.Models.TypeCompte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;

import javafx.scene.control.Button;

public class compteController implements Initializable {
    @FXML
    private Button btn_valider;

    @FXML
    private Button btn_activ;

    @FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_search;

    @FXML
    private Label lab_cin;

    @FXML
    private Label lab_et;

    @FXML
    private Label lab_id;

    @FXML
    private Label lab_sol;

    @FXML
    private Label lab_ty;

    @FXML
    private Label label;

    @FXML
    private TableColumn<ClientModel, Long> tc_cin;

    @FXML
    private TableColumn<CompteModel, Boolean> tc_etat;

    @FXML
    private TableColumn<CompteModel, Long> tc_num;

    @FXML
    private TableColumn<CompteModel, Float> tc_sol;

    @FXML
    private TableColumn<CompteModel, String> tc_ty;

    @FXML
    private TextField tf_cin;

    @FXML
    private TableView<CompteModel> tv_comptes;

    @FXML
    private ComboBox<TypeCompte> cb_type;
    @FXML
    private TextField tf_ci_add;


    CompteModel cpt;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cb_type.getItems().setAll(TypeCompte.values());
        btn_valider.setOnMouseClicked(event -> {
        ouvrirCompte();
    });


    }


    @FXML
    public void ouvrirCompte() {
        Long cin;
        String type;
        cin = Long.parseLong(tf_ci_add.getText());
        type = String.valueOf(cb_type.getSelectionModel().getSelectedItem());

        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql = "INSERT INTO `comptes`(`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES ('',?,0,?,1)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,type);
            pstmt.setLong(2, cin);
            System.out.println("......kamalt....");
            pstmt.executeUpdate();
            PreparedStatement pst;
            pst = conn.prepareStatement("select * from clients where id_clt = (select max(id_clt) from clients) ");
            ResultSet rs = pst.executeQuery();


        } catch (SQLException e) {
            System.out.println("......ntStackTracehahahhahah.....");
            e.printStackTrace();
        }

        System.out.println("......hahahhahah.....");
    }

    /*@FXML
    public void loadData() {
        Connection conn;
        PreparedStatement pst;
        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes");
            ResultSet rs = pst.executeQuery();
            tv_comptes.getItems().clear();


            while (rs.next()) {
                tc_num.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("num_c"));
                tc_ty.setCellValueFactory(new PropertyValueFactory<CompteModel,String>("type_c"));
                tc_sol.setCellValueFactory(new PropertyValueFactory<CompteModel,Float>("solde_c"));
                tc_cin.setCellValueFactory(new PropertyValueFactory<ClientModel,Long>("id_clt"));
                tc_etat.setCellValueFactory(new PropertyValueFactory<CompteModel,Boolean>("etat"));

                ObservableList<CompteModel> data = FXCollections.observableArrayList(
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
    }*/




    /*@FXML
    public void load_ligne() {
        Connection conn;
        PreparedStatement pst;

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
    }*/

    /*@FXML
    void ajouterclt(ActionEvent event) {

        Parent root = null;

        try {
            URL url = new File("src/main/resources/com/bank/Views/ajouterClient.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle("Ajouter client");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(e -> load_ligne());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    /*public void deleteClient(ActionEvent ae){
        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql="delete from clients where id_clt=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setLong(1,Long.parseLong(labelid.getText()));
            pstmt.executeUpdate();
            if(rs!=null){
                label.setText("Client supprimé avec succés ");
            }else{

                label.setText("Veuillez vérifier CIN client!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/

    /*@FXML
    public void onTableItemSelect(MouseEvent event){
        clt = tv_clients.getSelectionModel().getSelectedItem();
        if (clt != null){
            labelid.setText(String.valueOf(clt.getId_clt()));
            tf_sel_tel.setText(clt.getTel());
            tf_sel_email.setText(clt.getEmail());
            tf_sel_adr.setText(clt.getAdr());

        }
    }*/

    /*@FXML
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

    }*/


    /*@FXML
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
    }*/


}

