module com.aspro.aspro {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens com.aspro.aspro to javafx.fxml;
    opens com.aspro.aspro.model.entities to org.hibernate.orm.core;
    exports com.aspro.aspro.model.entities;
    exports com.aspro.aspro;
    exports com.aspro.aspro.controllers;
    opens com.aspro.aspro.controllers to javafx.fxml;
}