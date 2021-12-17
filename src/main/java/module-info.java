module com.example.basketballstats {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.basketballstats to javafx.fxml;
    exports com.example.basketballstats;
}