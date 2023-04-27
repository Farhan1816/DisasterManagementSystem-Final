package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class switchWindow {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    ImageView logoView;
    Image logo = new Image(getClass().getResourceAsStream("logo.jpg"));

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button loginButton;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void submit(ActionEvent event) throws IOException {

        String user, pass;
        user=username.getText();
        pass=password.getText();

        if((user.compareTo("abcd")==0) && (pass.compareTo("abcd")==0))
        {
            switchToMenu(event);
        }

    }

    public void switchToMenu(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}