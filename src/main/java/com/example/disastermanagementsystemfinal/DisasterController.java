package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;



public class DisasterController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button Disaster1, Disaster2, Disaster3, Disaster4, Disaster5;

    public void switchtoNewDisaster(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("NewDisaster.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoPrevDisaster(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("PrevDisaster.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
