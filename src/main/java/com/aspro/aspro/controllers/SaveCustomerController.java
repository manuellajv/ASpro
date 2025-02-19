package com.aspro.aspro.controllers;

import com.aspro.aspro.model.dao.CustomerDAO;
import com.aspro.aspro.model.services.CustomerService;
import com.aspro.aspro.util.Alerts;
import com.aspro.aspro.util.JpaUtil;
import com.aspro.aspro.util.NullValidator;
import com.aspro.aspro.util.ValueParser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SaveCustomerController  {

    private CustomerService service;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField cpfCnpjTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    public SaveCustomerController(){
        this.service = new CustomerService(new CustomerDAO(
                JpaUtil.getEntityManager()
        ));
    }

    private void clearFields (){
        nameTextField.clear();
        cpfCnpjTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();
    }

    @FXML
    private void saveCustomer(){
        try{

            TextField[] fields = {nameTextField, cpfCnpjTextField, phoneTextField};

            if(NullValidator.validateNull(fields)){return;}

            String customerName = nameTextField.getText();
            String cpfCnpj = cpfCnpjTextField.getText();
            Long phoneText = ValueParser.parseLong(phoneTextField.getText());
            String email = emailTextField.getText();

            service.saveCustomer(customerName, cpfCnpj, phoneText, email);

            Alerts.showAlerts("Sucesso", "Cadastro realizado.", "Cliente cadastrado com sucesso!", Alert.AlertType.INFORMATION);

            clearFields();

        } catch (Exception e){
            e.printStackTrace();
//           Alerts.showAlerts("Erro", "Erro ao cadastrar cliente.", "Houve um erro ao cadastrar o cliente." + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
