package com.aspro.aspro.controllers;

import com.aspro.aspro.model.dao.AddressDAO;
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

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField addrNumberTextField;

    @FXML
    private TextField complementTextField;

    @FXML
    private TextField districtTextField;

    @FXML
    private TextField zipCodeTextField;

    @FXML
    private TextField cityTextField;


    public SaveCustomerController(){
        this.service = new CustomerService(new CustomerDAO(
                JpaUtil.getEntityManager()), new AddressDAO(JpaUtil.getEntityManager()));
    }

    private void clearFields (){
        nameTextField.clear();
        cpfCnpjTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();
        streetTextField.clear();
        addrNumberTextField.clear();
        complementTextField.clear();
        districtTextField.clear();
        zipCodeTextField.clear();
        cityTextField.clear();
    }

    @FXML
    public void saveCustomer(){
        try{

            TextField[] fields = {nameTextField, cpfCnpjTextField, phoneTextField, streetTextField, addrNumberTextField, districtTextField, zipCodeTextField, cityTextField};

            if (NullValidator.validateNull(new TextField[]{nameTextField, cpfCnpjTextField, phoneTextField, emailTextField, streetTextField, addrNumberTextField, districtTextField, cityTextField, zipCodeTextField})) {
                Alerts.showAlerts("Erro", "Campos obrigatórios não preenchidos", "Preencha todos os campos antes de cadastrar!", Alert.AlertType.ERROR);
                return;
            }

            String customerName = nameTextField.getText();
            String cpfCnpj = cpfCnpjTextField.getText();
            Long phoneText = ValueParser.parseLong(phoneTextField.getText());
            String email = emailTextField.getText();

            String street = streetTextField.getText();
            Short addrNumber = ValueParser.parseShort(addrNumberTextField.getText());
            String district = districtTextField.getText();
            Long zipCode = ValueParser.parseLong(zipCodeTextField.getText());
            String city = cityTextField.getText();
            String complement = complementTextField.getText();

            service.saveCustomer(customerName, cpfCnpj, phoneText, email, zipCode, street, addrNumber, district, city, complement);

            Alerts.showAlerts("Sucesso", "Cadastro realizado.", "Cliente cadastrado com sucesso!", Alert.AlertType.INFORMATION);

            clearFields();

        } catch (Exception e){
            e.printStackTrace();
//           Alerts.showAlerts("Erro", "Erro ao cadastrar cliente.", "Houve um erro ao cadastrar o cliente." + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
