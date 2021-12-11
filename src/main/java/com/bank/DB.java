package com.bank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {


 Connection conn;
 String databaseName = "bank";
 String databaseUser = "root";
 String databasePassword = "";
 String url="jdbc:mysql://localhost/"+ databaseName;

 public DB(){}

 public void connect(){

     try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       conn = (Connection) DriverManager.getConnection(url,databaseUser,databasePassword);
       System.out.println("Connection succeed.........");
       } catch (ClassNotFoundException | SQLException e) {
       e.printStackTrace();
      System.out.println("Connection failed.........");

     }

 }

 public Connection getConnection()  {
      try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(url,databaseUser,databasePassword);
          } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            }
  return conn;
 }
}
