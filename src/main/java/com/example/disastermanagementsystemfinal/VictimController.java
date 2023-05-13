package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class VictimController implements Initializable {

    public int option=0;
    private Stage stage;
    private Scene scene;
    private Parent root;

   @FXML
   private Button Disaster1, Disaster2, Disaster3, Disaster4, Disaster5;

    private  int arr[]= new int[10];

    public void switchtoDisasterCasualties(ActionEvent event, int option) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterCasualties.fxml"));

        if(option==1 && arr[1]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(1);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(1);
        }
        else if(option==2 && arr[2]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(2);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(2);
        }
        else if(option==3 && arr[3]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(3);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(3);
        }
        else if(option==4 && arr[4]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(4);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(4);
        }
        else if(option==5 && arr[5]==1){
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(5);
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

    public void switchPage(ActionEvent e) throws IOException {
        Button button=(Button)e.getSource();

        if(button.getId().equals("Disaster1"))
        {
            if(arr[1]==1)
            {
                switchtoDisasterCasualties(e, 1);
            }
            option=1;
        }
        if(button.getId().equals("Disaster2"))
        {
            option=2;
            if(arr[2]==1)
            {
                switchtoDisasterCasualties(e, 2);
            }
        }
        if(button.getId().equals("Disaster3"))
        {
            option=3;
            if(arr[3]==1)
            {
                switchtoDisasterCasualties(e, 3);
            }
        }
        if(button.getId().equals("Disaster4"))
        {
            option=4;
            if(arr[4]==1)
            {
                switchtoDisasterCasualties(e, 4);
            }

        }
        if(button.getId().equals("Disaster5"))
        {
            option=5;
            if(arr[5]==1)
            {
                switchtoDisasterCasualties(e, 5);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/status", "farhan", "henloworld");
            psCheck =  connection.prepareStatement("select * from disasterStatus");
            resultSet =  psCheck.executeQuery();
            while (resultSet.next())
            {
                for(int i=1;i<=5;i++)
                {
                    arr[i]=resultSet.getInt(i);

                    if(arr[i]==1)
                    {
                        String str= new String("Disaster ");
                        str+=String.valueOf(i);
                        if(i==1)Disaster1.setText(str);
                        else if(i==2)Disaster2.setText(str);
                        else if(i==3)Disaster3.setText(str);
                        else if(i==4)Disaster4.setText(str);
                        else
                        {
                            Disaster5.setText(str);
                        }
                    }

                    else {

                        String str = new String("Add");
                        if(i==1)Disaster1.setText(str);
                        else if(i==2)Disaster2.setText(str);
                        else if(i==3)Disaster3.setText(str);
                        else if(i==4)Disaster4.setText(str);
                        else
                        {
                            Disaster5.setText(str);
                        }
                    }
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}


