package com.bank;


import com.bank.Models.ClientModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Date;

public class DB {


    Connection conn;
    String databaseName = "bank";
    String databaseUser = "root";
    String databasePassword = "";
    String url = "jdbc:mysql://localhost/" + databaseName;

    public DB() {
    }

    public void connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("Connection succeed.........");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed.........");

        }

    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ObservableList<ClientModel> getClientsData() {
        DB db = new DB();
        Connection conn = db.getConnection();

        ObservableList<ClientModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from clients");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ClientModel(Long.parseLong(rs.getString("id_clt")), rs.getDate("date_n"), rs.getString("tel"), rs.getNString("email"), rs.getString("adr")));

            }
        } catch (Exception e) {
        }
        return list;
    }


}