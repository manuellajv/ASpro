package com.aspro.aspro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private TreeView<String> menuTreeView;
    @FXML
    private AnchorPane contentPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        createTreeView();
    }
    
    private void createTreeView(){
        TreeItem<String> customers = new TreeItem<>("Clientes");
        TreeItem<String> materials = new TreeItem<>("Materiais");
        TreeItem<String> orders = new TreeItem<>("Orçamentos");
        TreeItem<String> vehicles = new TreeItem<>("Veículos");

        TreeItem<String> registerCustomer = new TreeItem<>("Cadastrar Cliente");
        TreeItem<String> modifyCustomer = new TreeItem<>("Modificar Cliente");
        TreeItem<String> viewCustomer = new TreeItem<>("Visualizar Cliente");

        TreeItem<String> registerMaterial = new TreeItem<>("Cadastrar Material");
        TreeItem<String> modifyMaterial = new TreeItem<>("Modificar Material");
        TreeItem<String> viewMaterial = new TreeItem<>("Visualizar Material");

        TreeItem<String> registerOrder = new TreeItem<>("Novo Orçamento");
        TreeItem<String> modifyOrder = new TreeItem<>("Modificar Orçamento");
        TreeItem<String> viewOrder = new TreeItem<>("Visualizar Orçamento");

        TreeItem<String> registerVehicle = new TreeItem<>("Cadastrar Veiculo");
        TreeItem<String> modifyVehicle = new TreeItem<>("Modificar Veiculo");
        TreeItem<String> viewVehicle = new TreeItem<>("Visualizar Veiculo");

        customers.getChildren().addAll(registerCustomer, modifyCustomer, viewCustomer);
        materials.getChildren().addAll(registerMaterial, modifyMaterial, viewMaterial);
        orders.getChildren().addAll(registerOrder, modifyOrder, viewOrder);
        vehicles.getChildren().addAll(registerVehicle, modifyVehicle, viewVehicle);

        TreeItem<String> root = new TreeItem<>("Menu");
        root.getChildren().addAll(customers, materials, orders, vehicles);

        menuTreeView.setRoot(root);
        menuTreeView.setShowRoot(false);

        menuTreeView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null){
                updateScreen(newValue);
            }
        });
    }
    private void updateScreen(TreeItem<String> item) {
        var itemValue = item.getValue().toLowerCase();
        switch (itemValue){
            case "cadastrar cliente":
                loadView("teste.fxml");
                break;
            case "modificar cliente":
                System.out.println("modificar cliente");
                break;
            case "visualizar cliente":
                System.out.println("visualizar cliente");
                break;
            case "cadastrar material":
                System.out.println("cadastrar material");
                break;
            case "modificar material":
                System.out.println("modificar material");
                break;
            case "visualizar material":
                System.out.println("visualizar material");
                break;
        }

    }

    public void loadView(String view){
        try {
            contentPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STR."/fxml/\{view}"));
            AnchorPane content = loader.load();

            AnchorPane.setTopAnchor(content, 0.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);


            contentPane.getChildren().add(content);
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void sysExit(){
        System.exit(0);
    }
}
