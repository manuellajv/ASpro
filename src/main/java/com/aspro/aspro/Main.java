package com.aspro.aspro;

import com.aspro.aspro.util.JpaUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        JpaUtil.createEmf();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setMaximized(true);
//        stage.setResizable(false);
        stage.setTitle("ASpro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}