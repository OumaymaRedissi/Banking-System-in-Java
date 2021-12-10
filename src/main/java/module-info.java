module com.example.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.bank to javafx.fxml;
    exports com.bank;
    exports com.bank.Controllers;
    opens com.bank.Controllers to javafx.fxml;
}