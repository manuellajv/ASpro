package com.aspro.aspro.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
    public static void showAlerts(String title, String header, String msg, AlertType typeAlert){
        Alert alert = new Alert(typeAlert);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        alert.show();
    }
}
