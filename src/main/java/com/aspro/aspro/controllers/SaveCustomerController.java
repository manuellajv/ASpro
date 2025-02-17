package com.aspro.aspro.controllers;

import com.aspro.aspro.model.dao.CustomerDAO;
import com.aspro.aspro.model.services.CustomerService;
import com.aspro.aspro.util.Alerts;
import com.aspro.aspro.util.JpaUtil;
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

    @FXML
    private void saveCustomer(){
        try{
            String customerName = nameTextField.getText();
            String cpfCnpj = cpfCnpjTextField.getText();
            String phoneText = phoneTextField.getText();
            String email = emailTextField.getText();

            if (customerName.isEmpty() || cpfCnpj.isEmpty() || phoneText.isEmpty()){
                Alerts.showAlerts("Erro!", "Campos obrigatórios.", "Todos os campos devem ser preenchidos.", Alert.AlertType.ERROR);
                return;
            }

            Long phone = Long.parseLong(String.valueOf(phoneText));

            service.saveCustomer(customerName, cpfCnpj, phone, email);

            Alerts.showAlerts("Sucesso!", "Cadastro realizado.", "Cliente cadastrado com sucesso!", Alert.AlertType.INFORMATION);

            nameTextField.clear();
            cpfCnpjTextField.clear();
            phoneTextField.clear();
            emailTextField.clear();

        } catch (Exception e){
           Alerts.showAlerts("Erro!", "Erro ao cadastrar cliente.", "Houve um erro ao cadastrar o cliente." + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
