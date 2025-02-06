module com.aspro.aspro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aspro.aspro to javafx.fxml;
    exports com.aspro.aspro;
}