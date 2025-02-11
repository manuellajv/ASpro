package com.aspro.aspro.controllers;

import com.sun.source.tree.Tree;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private TreeView<String> menuTreeView;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        TreeItem<String> customers = new TreeItem<>("Clientes");
        TreeItem<String> materials = new TreeItem<>("Materiais");
        TreeItem<String> orders = new TreeItem<>("Orçamentos");
        TreeItem<String> vehicles = new TreeItem<>("Veículos");

        TreeItem<String> registerCustomer = new TreeItem<>("Cadastrar");
        TreeItem<String> modifyCustomer = new TreeItem<>("Modificar");
        TreeItem<String> viewCustomer = new TreeItem<>("Visualizar");

        TreeItem<String> registerMaterial = new TreeItem<>("Cadastrar");
        TreeItem<String> modifyMaterial = new TreeItem<>("Modificar");
        TreeItem<String> viewMaterial = new TreeItem<>("Visualizar");

        TreeItem<String> registerOrder = new TreeItem<>("Cadastrar");
        TreeItem<String> modifyOrder = new TreeItem<>("Modificar");
        TreeItem<String> viewOrder = new TreeItem<>("Visualizar");

        TreeItem<String> registerVehicle = new TreeItem<>("Cadastrar");
        TreeItem<String> modifyVehicle = new TreeItem<>("Modificar");
        TreeItem<String> viewVehicle = new TreeItem<>("Visualizar");

        customers.getChildren().addAll(registerCustomer, modifyCustomer, viewCustomer);
        materials.getChildren().addAll(registerMaterial, modifyMaterial, viewMaterial);
        orders.getChildren().addAll(registerOrder, modifyOrder, viewOrder);
        vehicles.getChildren().addAll(registerVehicle, modifyVehicle, viewVehicle);

        TreeItem<String> root = new TreeItem<>("Menu");
        root.getChildren().addAll(customers, materials, orders, vehicles);

        menuTreeView.setRoot(root);
        menuTreeView.setShowRoot(false);

    }

    public void selectItem(){

    }
}
