package com.bank.Controllers;


import com.bank.DB;
import com.bank.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class transactionController implements Initializable {

    @FXML
    private Button btn_load;


    @FXML
    private TableView<DepotModel> tv_depot;

    @FXML
    private TableColumn<DepotModel, Date> tc_dep_date;

    @FXML
    private TableColumn<DepotModel, Long> tc_dep_em;

    @FXML
    private TableColumn<DepotModel, Float> tc_dep_mnt;

    @FXML
    private TableColumn<DepotModel, Long> tc_dep_op;

    @FXML
    private TableView<RetraitModel> tv_retrait;


    @FXML
    private TableColumn<RetraitModel, Date> tc_ret_date;

    @FXML
    private TableColumn<RetraitModel, Long> tc_ret_em;

    @FXML
    private TableColumn<RetraitModel, Float> tc_ret_mnt;

    @FXML
    private TableColumn<RetraitModel, Long> tc_ret_op;

    @FXML
    private TableView<VirementModel> tv_virement;

    @FXML
    private TableColumn<VirementModel, Long> tc_vir_ben;

    @FXML
    private TableColumn<VirementModel, Date> tc_vir_date;

    @FXML
    private TableColumn<VirementModel, Long> tc_vir_em;

    @FXML
    private TableColumn<VirementModel, Float> tc_vir_mnt;

    @FXML
    private TableColumn<VirementModel, Long> tc_vir_op;

    @FXML
    private Button btn_conf1;

    @FXML
    private Button btn_conf2;

    @FXML
    private Button btn_conf3;

    @FXML
    private Button btn_search1;

    @FXML
    private Button btn_search2;

    @FXML
    private Button btn_search3;

    @FXML
    private Label lab_err1;

    @FXML
    private Label lab_err2;

    @FXML
    private Label lab_err3;

    @FXML
    private Label lab_cin1;

    @FXML
    private Label lab_cin2;

    @FXML
    private Label lab_cin3;

    @FXML
    private Label lab_cin4;

    @FXML
    private Label lab_et1;

    @FXML
    private Label lab_et2;

    @FXML
    private Label lab_et3;

    @FXML
    private Label lab_et4;

    @FXML
    private Label lab_id1;

    @FXML
    private Label lab_id2;

    @FXML
    private Label lab_id3;

    @FXML
    private Label lab_id4;

    @FXML
    private Label lab_sol1;

    @FXML
    private Label lab_sol2;

    @FXML
    private Label lab_sol3;

    @FXML
    private Label lab_sol4;

    @FXML
    private Label lab_ty1;

    @FXML
    private Label lab_ty2;

    @FXML
    private Label lab_ty3;

    @FXML
    private Label lab_ty4;
    @FXML
    private TextField tf_mnt1;

    @FXML
    private TextField tf_mnt2;

    @FXML
    private TextField tf_mnt3;

    @FXML
    private TextField tf_num1;

    @FXML
    private TextField tf_num2;

    @FXML
    private TextField tf_num3;

    @FXML
    private TextField tf_num4;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_load.setOnMouseClicked(event -> {
            loadDataDepot();
            loadDataRetrait();
            loadDataVirement();
        });
        btn_search1.setOnMouseClicked(event -> {
            searchNUMCompte1();
        });
        btn_search2.setOnMouseClicked(event -> {
            searchNUMCompte2();
        });

        btn_search3.setOnMouseClicked(event -> {
            searchNUMCompte3();
            searchNUMCompte4();
        });

        btn_conf1.setOnMouseClicked(event -> {
            updateCompteDepot();
        });

        btn_conf2.setOnMouseClicked(event -> {
            updateCompteRetrait();
        });

        btn_conf3.setOnMouseClicked(event -> {
            updateCompteVirement();
        });


    }

    @FXML
    public void loadDataDepot() {
        Connection conn;
        PreparedStatement pst;
        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from transactions where type_op=1");
            ResultSet rs = pst.executeQuery();
            tv_depot.getItems().clear();


            while (rs.next()) {
                tc_dep_op.setCellValueFactory(new PropertyValueFactory<DepotModel, Long>("num_op"));
                tc_dep_date.setCellValueFactory(new PropertyValueFactory<DepotModel, Date>("date_op"));
                tc_dep_mnt.setCellValueFactory(new PropertyValueFactory<DepotModel, Float>("mnt_op"));
                tc_dep_em.setCellValueFactory(new PropertyValueFactory<DepotModel, Long>("num_c_em"));

                ObservableList<DepotModel> data = FXCollections.observableArrayList(
                        new DepotModel(rs.getLong("num_op"),
                                rs.getDate("date_op"),
                                rs.getDouble("mnt_op"),
                                rs.getLong("num_c_em")
                        ));
                tv_depot.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadDataRetrait() {
        Connection conn;
        PreparedStatement pst;
        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from transactions where type_op=2");
            ResultSet rs = pst.executeQuery();
            tv_retrait.getItems().clear();


            while (rs.next()) {
                tc_ret_op.setCellValueFactory(new PropertyValueFactory<RetraitModel, Long>("num_op"));
                tc_ret_date.setCellValueFactory(new PropertyValueFactory<RetraitModel, Date>("date_op"));
                tc_ret_mnt.setCellValueFactory(new PropertyValueFactory<RetraitModel, Float>("mnt_op"));
                tc_ret_em.setCellValueFactory(new PropertyValueFactory<RetraitModel, Long>("num_c_em"));

                ObservableList<RetraitModel> data = FXCollections.observableArrayList(
                        new RetraitModel(rs.getLong("num_op"),
                                rs.getDate("date_op"),
                                rs.getDouble("mnt_op"),
                                rs.getLong("num_c_em")
                        ));
                tv_retrait.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadDataVirement() {
        Connection conn;
        PreparedStatement pst;
        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from transactions where type_op=3");
            ResultSet rs = pst.executeQuery();
            tv_virement.getItems().clear();


            while (rs.next()) {
                tc_vir_op.setCellValueFactory(new PropertyValueFactory<VirementModel, Long>("num_op"));
                tc_vir_date.setCellValueFactory(new PropertyValueFactory<VirementModel, Date>("date_op"));
                tc_vir_mnt.setCellValueFactory(new PropertyValueFactory<VirementModel, Float>("mnt_op"));
                tc_vir_em.setCellValueFactory(new PropertyValueFactory<VirementModel, Long>("num_c_em"));
                tc_vir_ben.setCellValueFactory(new PropertyValueFactory<VirementModel, Long>("num_c_ben"));

                ObservableList<VirementModel> data = FXCollections.observableArrayList(
                        new VirementModel(rs.getLong("num_op"),
                                rs.getDate("date_op"),
                                rs.getDouble("mnt_op"),
                                rs.getLong("num_c_em"),
                                rs.getLong("num_c_ben")
                        ));
                tv_virement.getItems().addAll(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void searchNUMCompte1() {
        Connection conn;
        PreparedStatement pst;

        long num = Long.parseLong(tf_num1.getText());

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE num_c = ?");
            pst.setLong(1, num);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lab_id1.setText(String.valueOf(Long.parseLong(rs.getString("num_c"))));
                lab_ty1.setText(String.valueOf(TypeCompte.valueOf(rs.getString("type_c"))));
                lab_sol1.setText(String.valueOf(rs.getFloat("solde_c")));
                lab_cin1.setText(String.valueOf(rs.getLong("id_c")));
                if (rs.getBoolean("etat"))
                    lab_et1.setText("Ouvert");
                else
                    lab_et1.setText("Cloturé");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void searchNUMCompte2() {
        Connection conn;
        PreparedStatement pst;

        long num = Long.parseLong(tf_num2.getText());

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE num_c = ?");
            pst.setLong(1, num);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lab_id2.setText(String.valueOf(Long.parseLong(rs.getString("num_c"))));
                lab_ty2.setText(String.valueOf(TypeCompte.valueOf(rs.getString("type_c"))));
                lab_sol2.setText(String.valueOf(rs.getFloat("solde_c")));
                lab_cin2.setText(String.valueOf(rs.getLong("id_c")));
                if (rs.getBoolean("etat"))
                    lab_et2.setText("Ouvert");
                else
                    lab_et2.setText("Cloturé");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void searchNUMCompte3() {
        Connection conn;
        PreparedStatement pst;

        long num = Long.parseLong(tf_num3.getText());

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE num_c = ?");
            pst.setLong(1, num);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lab_id3.setText(String.valueOf(Long.parseLong(rs.getString("num_c"))));
                lab_ty3.setText(String.valueOf(TypeCompte.valueOf(rs.getString("type_c"))));
                lab_sol3.setText(String.valueOf(rs.getFloat("solde_c")));
                lab_cin3.setText(String.valueOf(rs.getLong("id_c")));
                if (rs.getBoolean("etat"))
                    lab_et3.setText("Ouvert");
                else
                    lab_et3.setText("Cloturé");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void searchNUMCompte4() {
        Connection conn;
        PreparedStatement pst;

        long num = Long.parseLong(tf_num4.getText());

        try {
            DB db = new DB();
            conn = db.getConnection();
            pst = conn.prepareStatement("select * from comptes WHERE num_c = ?");
            pst.setLong(1, num);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lab_id4.setText(String.valueOf(Long.parseLong(rs.getString("num_c"))));
                lab_ty4.setText(String.valueOf(TypeCompte.valueOf(rs.getString("type_c"))));
                lab_sol4.setText(String.valueOf(rs.getFloat("solde_c")));
                lab_cin4.setText(String.valueOf(rs.getLong("id_c")));
                if (rs.getBoolean("etat"))
                    lab_et4.setText("Ouvert");
                else
                    lab_et4.setText("Cloturé");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateCompteDepot() {


        Connection conn;
        PreparedStatement pst;
        CompteModel cpt = new CompteModel(Long.parseLong(lab_id1.getText()),
                TypeCompte.valueOf(lab_ty1.getText()),
                Float.parseFloat(lab_sol1.getText()),
                Long.parseLong(lab_cin1.getText())
        );

        if ("Cloturé".equals(lab_et1.getText())) {
            cpt.setEtat(false);
            lab_err1.setText("Compte cloturé - transaction impossible");
        } else {
            cpt.setEtat(true);

            Double montant = Double.valueOf(tf_mnt1.getText());
            cpt.Depot(montant);

            try {
                DB db = new DB();
                conn = db.getConnection();
                String sql = "UPDATE comptes SET solde_c=?  WHERE num_c=?";
                pst = conn.prepareStatement(sql);
                pst.setDouble(1, cpt.getSolde_c());
                pst.setLong(2, cpt.getNum_c());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            formatter.format(date);
            long timeInMilliSeconds = date.getTime();
            java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);

            DepotModel depot = new DepotModel(date, montant, cpt.getNum_c());
            //Date date_op, float mnt_op,long num_c_em
            try {
                DB db = new DB();
                conn = db.getConnection();
                String sql = "INSERT INTO `transactions`( `type_op`, `date_op`, `mnt_op`, `num_c_em`) VALUES (1,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setDate(1, sqlDate);
                pst.setDouble(2, montant);
                pst.setLong(3, cpt.getNum_c());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            lab_sol1.setText(String.valueOf(cpt.getSolde_c()));
        }
    }

    @FXML
    private void updateCompteRetrait() {

        Connection conn;
        PreparedStatement pst;
        CompteModel cpt = new CompteModel(Long.parseLong(lab_id2.getText()),
                TypeCompte.valueOf(lab_ty2.getText()),
                Float.parseFloat(lab_sol2.getText()),
                Long.parseLong(lab_cin2.getText())
        );
        if ("Cloturé".equals(lab_et2.getText())) {
            cpt.setEtat(false);
            lab_err2.setText("Compte cloturé - transaction impossible");
        }
        if ((Float.parseFloat(lab_sol2.getText()) < Double.valueOf(tf_mnt2.getText())))
            lab_err2.setText("Solde insuffisant - transaction impossible");

        else {
            cpt.setEtat(true);

            if ("Ouvert".equals(lab_et2.getText()))
                cpt.setEtat(true);
            else
                cpt.setEtat(false);

            Double montant = Double.valueOf(tf_mnt2.getText());
            cpt.Retrait(montant);

            try {
                DB db = new DB();
                conn = db.getConnection();
                String sql = "UPDATE comptes SET solde_c=?  WHERE num_c=?";
                pst = conn.prepareStatement(sql);
                pst.setDouble(1, cpt.getSolde_c());
                pst.setLong(2, cpt.getNum_c());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            formatter.format(date);
            long timeInMilliSeconds = date.getTime();
            java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);

            DepotModel depot = new DepotModel(date, montant, cpt.getNum_c());
            //Date date_op, float mnt_op,long num_c_em
            try {
                DB db = new DB();
                conn = db.getConnection();
                String sql = "INSERT INTO `transactions`( `type_op`, `date_op`, `mnt_op`, `num_c_em`) VALUES (2,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setDate(1, sqlDate);
                pst.setDouble(2, montant);
                pst.setLong(3, cpt.getNum_c());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            lab_sol2.setText(String.valueOf(cpt.getSolde_c()));
        }
    }

    @FXML
    private void updateCompteVirement() {

        Connection conn;
        PreparedStatement pst;
        if (tf_mnt3.getText() == "") {
            lab_err3.setText("Entrez un montant");

        } else {

        }
        CompteModel cpt1 = new CompteModel(Long.parseLong(lab_id3.getText()),
                TypeCompte.valueOf(lab_ty3.getText()),
                Float.parseFloat(lab_sol3.getText()),
                Long.parseLong(lab_cin3.getText())
        );

        CompteModel cpt2 = new CompteModel(Long.parseLong(lab_id4.getText()),
                TypeCompte.valueOf(lab_ty4.getText()),
                Float.parseFloat(lab_sol4.getText()),
                Long.parseLong(lab_cin4.getText())
        );

        if ("Cloturé".equals(lab_et3.getText())) {
            cpt1.setEtat(false);
            lab_err3.setText("Compte cloturé - transaction impossible");
        } else {
            if ("Cloturé".equals(lab_et4.getText())) {
                cpt2.setEtat(false);
                lab_err3.setText("Compte cloturé - transaction impossible");
            } else {
                if ((Float.parseFloat(lab_sol3.getText()) < Double.valueOf(tf_mnt3.getText())))
                    lab_err3.setText("Solde insuffisant - transaction impossible");

                else {

                    Double montant = Double.valueOf(tf_mnt3.getText());
                    cpt1.virerVers(cpt2, montant);

                    try {
                        DB db = new DB();
                        conn = db.getConnection();
                        String sql = "UPDATE comptes SET solde_c=?  WHERE num_c=?";
                        pst = conn.prepareStatement(sql);
                        pst.setDouble(1, cpt1.getSolde_c());
                        pst.setLong(2, cpt1.getNum_c());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        DB db = new DB();
                        conn = db.getConnection();
                        String sql = "UPDATE comptes SET solde_c=?  WHERE num_c=?";
                        pst = conn.prepareStatement(sql);
                        pst.setDouble(1, cpt2.getSolde_c());
                        pst.setLong(2, cpt2.getNum_c());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    formatter.format(date);
                    long timeInMilliSeconds = date.getTime();
                    java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);

                    VirementModel depot = new VirementModel(date, montant, cpt1.getNum_c(), cpt2.getNum_c());
                    //Date date_op, float mnt_op,long num_c_em
                    try {
                        DB db = new DB();
                        conn = db.getConnection();
                        String sql = "INSERT INTO `transactions`( `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES (3,?,?,?,?)";
                        pst = conn.prepareStatement(sql);
                        pst.setDate(1, sqlDate);
                        pst.setDouble(2, montant);
                        pst.setLong(3, cpt1.getNum_c());
                        pst.setLong(4, cpt2.getNum_c());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    lab_sol3.setText(String.valueOf(cpt1.getSolde_c()));
                    lab_sol4.setText(String.valueOf(cpt2.getSolde_c()));


                }
            }
        }
    }
}
