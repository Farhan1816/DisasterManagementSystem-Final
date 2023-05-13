package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Controller {
    public void logout(ActionEvent e)
    {
        Stage stage;
        Scene scene;
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene((root));
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
    }
}
