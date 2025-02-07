module com.example.aspro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aspro to javafx.fxml;
    exports com.example.aspro;
}