module com.example.commissioncalculator_group21 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.commissioncalculator_group21 to javafx.fxml;
    exports com.example.commissioncalculator_group21;
}