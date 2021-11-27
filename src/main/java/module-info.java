module com.example.bank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bank to javafx.fxml;
    exports com.example.bank;
    exports com.example.bank.Controllers;
    opens com.example.bank.Controllers to javafx.fxml;
}