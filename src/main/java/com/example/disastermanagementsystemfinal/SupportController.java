package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SupportController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    @FXML
    void Button1(ActionEvent event ) throws IOException
    {
       FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("supportDetails.fxml"));
            root = loader.load();

            supportDetailsController controller = (supportDetailsController) loader.getController();
            controller.setType(1);
            controller.init();

            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

    }
    @FXML
    void Button2(ActionEvent event ) throws IOException
    {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("supportDetails.fxml"));
        root = loader.load();

        supportDetailsController controller = (supportDetailsController) loader.getController();
        controller.setType(2);
            controller.init();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void Button3(ActionEvent event ) throws IOException
    {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("supportDetails.fxml"));
        root = loader.load();

        supportDetailsController controller = (supportDetailsController) loader.getController();
        controller.setType(3);
            controller.init();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void Button4(ActionEvent event ) throws IOException
    {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("supportDetails.fxml"));
        root = loader.load();

        supportDetailsController controller = (supportDetailsController) loader.getController();
        controller.setType(4);
            controller.init();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void Button5(ActionEvent event ) throws IOException
    {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("supportDetails.fxml"));
        root = loader.load();

        supportDetailsController controller = (supportDetailsController) loader.getController();
        controller.setType(5);
        controller.init();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public  void returnToMenu(ActionEvent event ) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
