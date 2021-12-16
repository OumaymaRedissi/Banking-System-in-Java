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
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.control.Button;

public class compteController implements Initializable {
    @FXML
    private Button btn_valider;
    @FXML
    private Button btn_load;

    @FXML
    private Button btn_activ;

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
    private TableColumn<CompteModel, Long> tc_cin;

    @FXML
    private TableColumn<CompteModel, Boolean> tc_etat;

    @FXML
    private TableColumn<CompteModel, Long> tc_num;

    @FXML
    private TableColumn<CompteModel, Float> tc_sol;

    @FXML
    private TableColumn<CompteModel, String> tc_ty;

    @FXML
    private TableView<CompteModel> tv_comptes;

    @FXML
    private TextField tf_cin;
    @FXML
    private ComboBox<TypeCompte> cb_type;
    @FXML
    private TextField tf_ci_add;
    @FXML
    private RadioButton rb_activ;
    @FXML
    private RadioButton rb_desactiv;
    @FXML
    private RadioButton rb_both;






    CompteModel cpt;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup radioGroup = new ToggleGroup();
        rb_activ.setToggleGroup(radioGroup);
        rb_desactiv.setToggleGroup(radioGroup);
        rb_both.setToggleGroup(radioGroup);


        cb_type.getItems().setAll(TypeCompte.values());
        tv_comptes.setOnMouseClicked(event -> {
            onTableItemSelect();
        });
        rb_activ.setOnMouseClicked(event -> {
            searchActivCompte();
        });
        rb_desactiv.setOnMouseClicked(event -> {
            searchDesactivCompte();
        });
        rb_both.setOnMouseClicked(event -> {
            loadData();
        });
        btn_valider.setOnMouseClicked(event -> {
            confirAjout();
            ouvrirCompte();
            loadData();
        });
        btn_load.setOnMouseClicked(event -> {
            loadData();
        });
        btn_activ.setOnMouseClicked(event -> {
            act_desacCompte();
            onTableItemSelect();
            loadData();
        });
        btn_search.setOnMouseClicked(event -> {
            searchCINCompte();
        });
    }


    @FXML
    public void ouvrirCompte() {
        long cin;
        String type;
        cin = Long.parseLong(tf_ci_add.getText());
        type = String.valueOf(cb_type.getSelectionModel().getSelectedItem());

        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql = "INSERT INTO `comptes`(`type_c`, `solde_c`, `id_c`, `etat`) VALUES (?,0,?,1)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,type);
            pstmt.setLong(2, cin);
            System.out.println("......kamalt....");
            pstmt.executeUpdate();
            PreparedStatement pst;
            pst = conn.prepareStatement("select * from clients where id_clt = (select max(id_clt) from clients) ");
            ResultSet rs = pst.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
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
                tc_cin.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("id_c"));
                tc_etat.setCellValueFactory(new PropertyValueFactory<CompteModel,Boolean>("etat"));

                ObservableList<CompteModel> data = FXCollections.observableArrayList(
                        new CompteModel(Long.parseLong(rs.getString("num_c") ),
                                TypeCompte.valueOf(rs.getString("type_c")),
                                rs.getFloat("solde_c"),
                                rs.getLong("id_c"),
                                rs.getBoolean("etat")
                                ));
                tv_comptes.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onTableItemSelect(){
        cpt = tv_comptes.getSelectionModel().getSelectedItem();
        if (cpt != null){
            lab_id.setText(String.valueOf(cpt.getNum_c()));
            lab_ty.setText(String.valueOf(cpt.getType_c()));
            lab_sol.setText(String.valueOf(cpt.getSolde_c()));
            lab_cin.setText(String.valueOf(cpt.getId_c()));
            if(cpt.isEtat())
                lab_et.setText("Ouvert");
            else
                lab_et.setText("Cloturé");

        }
    }
    @FXML
    private void confirAjout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ouvrir compte");
        alert.setHeaderText("Message: ");
        alert.setContentText("Veuillez confirmer!");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            this.label.setText("Pas de selection");
        } else if (option.get() == ButtonType.OK) {
            this.label.setText("Compte ouvert ");
        } else if (option.get() == ButtonType.CANCEL) {
            this.label.setText("Annulé");
        } else {
            this.label.setText("-");
        }
    }
    @FXML
    private void act_desacCompte(){

        Connection conn;
        cpt.setNum_c(Long.parseLong(lab_id.getText()));
        cpt.setId_c(Long.parseLong(lab_cin.getText()));
        if("Ouvert".equals(lab_et.getText()))
            cpt.setEtat(true);
        else
            cpt.setEtat(false);

        try {
            DB db = new DB();
            conn = db.getConnection();
            String sql = "UPDATE comptes SET etat= NOT etat  WHERE num_c=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, cpt.getNum_c());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void searchCINCompte()
    {
        Connection conn;
        PreparedStatement pst;

        long cin = Long.parseLong(tf_cin.getText());

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE id_c = ?");
            pst.setLong(1, cin);
            ResultSet rs = pst.executeQuery();
            tv_comptes.getItems().clear();

            while (rs.next()) {
                tc_num.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("num_c"));
                tc_ty.setCellValueFactory(new PropertyValueFactory<CompteModel,String>("type_c"));
                tc_sol.setCellValueFactory(new PropertyValueFactory<CompteModel,Float>("solde_c"));
                tc_cin.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("id_c"));
                tc_etat.setCellValueFactory(new PropertyValueFactory<CompteModel,Boolean>("etat"));

                ObservableList<CompteModel> data = FXCollections.observableArrayList(
                        new CompteModel(Long.parseLong(rs.getString("num_c") ),
                                TypeCompte.valueOf(rs.getString("type_c")),
                                rs.getFloat("solde_c"),
                                rs.getLong("id_c"),
                                rs.getBoolean("etat")
                        ));
                tv_comptes.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchActivCompte() {
        Connection conn;
        PreparedStatement pst;

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE etat = 1");
            ResultSet rs = pst.executeQuery();
            tv_comptes.getItems().clear();

            while (rs.next()) {
                tc_num.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("num_c"));
                tc_ty.setCellValueFactory(new PropertyValueFactory<CompteModel,String>("type_c"));
                tc_sol.setCellValueFactory(new PropertyValueFactory<CompteModel,Float>("solde_c"));
                tc_cin.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("id_c"));
                tc_etat.setCellValueFactory(new PropertyValueFactory<CompteModel,Boolean>("etat"));

                ObservableList<CompteModel> data = FXCollections.observableArrayList(
                        new CompteModel(Long.parseLong(rs.getString("num_c") ),
                                TypeCompte.valueOf(rs.getString("type_c")),
                                rs.getFloat("solde_c"),
                                rs.getLong("id_c"),
                                rs.getBoolean("etat")
                        ));
                tv_comptes.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchDesactivCompte() {
        Connection conn;
        PreparedStatement pst;

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE etat = 0");
            ResultSet rs = pst.executeQuery();
            tv_comptes.getItems().clear();

            while (rs.next()) {
                tc_num.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("num_c"));
                tc_ty.setCellValueFactory(new PropertyValueFactory<CompteModel,String>("type_c"));
                tc_sol.setCellValueFactory(new PropertyValueFactory<CompteModel,Float>("solde_c"));
                tc_cin.setCellValueFactory(new PropertyValueFactory<CompteModel,Long>("id_c"));
                tc_etat.setCellValueFactory(new PropertyValueFactory<CompteModel,Boolean>("etat"));

                ObservableList<CompteModel> data = FXCollections.observableArrayList(
                        new CompteModel(Long.parseLong(rs.getString("num_c") ),
                                TypeCompte.valueOf(rs.getString("type_c")),
                                rs.getFloat("solde_c"),
                                rs.getLong("id_c"),
                                rs.getBoolean("etat")
                        ));
                tv_comptes.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

