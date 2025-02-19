package com.aspro.aspro.util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class NullValidator {

    public static boolean validateNull(TextField[] fields){
        for (TextField field : fields){
            if(field.getText().isEmpty()){
                Alerts.showAlerts("Erro", "Campo não preenchido","Preencha todos os campos obrigatórios", Alert.AlertType.ERROR);
                return true;
            }
        }
        return false;
    }
}
