module com.example.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.bank to javafx.fxml;
    exports com.bank;
    exports com.bank.Controllers;
    opens com.bank.Controllers to javafx.fxml;
    exports com.bank.Models;
    opens com.bank.Models to javafx.fxml;

}