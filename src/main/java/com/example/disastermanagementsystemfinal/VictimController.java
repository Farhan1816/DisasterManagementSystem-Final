package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VictimController {

    public int option=0;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private  int arr[]= new int[10];

    public void switchtoDisasterCasualties(ActionEvent event, int option) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterCasualties.fxml"));

        if(option==1)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController(1);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(1);
        }
        else if(option==2)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController((int)2);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(2);
        }
        else if(option==3)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController(3);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(3);
        }
        else if(option==4)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController(4);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(4);
        }
        else {
            PrevDisasterController prevDisasterController = new PrevDisasterController(5);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(5);
        }
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}


