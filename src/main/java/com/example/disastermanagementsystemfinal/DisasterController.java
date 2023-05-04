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


public class DisasterController implements Initializable {

    public int option=0;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private  int arr[]= new int[10];

    @FXML
    private Button Disaster1, Disaster2, Disaster3, Disaster4, Disaster5, erase1, erase2, erase3, erase4, erase5;

    public void switchtoNewDisaster(ActionEvent event, int option) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewDisaster.fxml"));
        Parent root = loader.load();
        if(option==1)
        {
            NewDisasterController newDisasterController = loader.getController();
            newDisasterController.initData(1);
        }
        else if(option==2)
        {
            NewDisasterController newDisasterController = loader.getController();
            newDisasterController.initData(2);
        }
        else if(option==3)
        {
            NewDisasterController newDisasterController = loader.getController();
            newDisasterController.initData(3);
        }
        else if(option==4)
        {
            NewDisasterController newDisasterController = loader.getController();
            newDisasterController.initData(4);
        }
        else {
            NewDisasterController newDisasterController = loader.getController();
            newDisasterController.initData(5);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoPrevDisaster(ActionEvent event, int option) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PrevDisaster.fxml"));

        if(option==1)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController(1);
            loader.setController(null);
            loader.setLocation(getClass().getResource("PrevDisaster.fxml"));
            //prevDisasterController.initData(1);
        }
        else if(option==2)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController((int)2);
            loader.setController(null);
            loader.setLocation(getClass().getResource("PrevDisaster.fxml"));
            //prevDisasterController.initData(2);
        }
        else if(option==3)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController(3);
            loader.setController(null);
            loader.setLocation(getClass().getResource("PrevDisaster.fxml"));
            //prevDisasterController.initData(3);
        }
        else if(option==4)
        {
            PrevDisasterController prevDisasterController = new PrevDisasterController(4);
            loader.setController(null);
            loader.setLocation(getClass().getResource("PrevDisaster.fxml"));
            //prevDisasterController.initData(4);
        }
        else {
            PrevDisasterController prevDisasterController = new PrevDisasterController(5);
            loader.setController(null);
            loader.setLocation(getClass().getResource("PrevDisaster.fxml"));
            //prevDisasterController.initData(5);
        }
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    public void switchPage(ActionEvent e) throws IOException {
        Button button=(Button)e.getSource();

        if(button.getId().equals("Disaster1"))
        {
            if(arr[1]==1)
            {
                switchtoPrevDisaster(e, 1);
            }
            else {
                switchtoNewDisaster(e, 1);
            }
            option=1;
        }
        if(button.getId().equals("Disaster2"))
        {
            option=2;
            if(arr[2]==1)
            {
                switchtoPrevDisaster(e, 2);
            }
            else {
                switchtoNewDisaster(e, 2);
            }
        }
        if(button.getId().equals("Disaster3"))
        {
            option=3;
            if(arr[3]==1)
            {
                switchtoPrevDisaster(e, 3);
            }
            else {
                switchtoNewDisaster(e, 3);
            }
        }
        if(button.getId().equals("Disaster4"))
        {
            option=4;
            if(arr[4]==1)
            {
                switchtoPrevDisaster(e, 4);
            }
            else {
                switchtoNewDisaster(e, 4);
            }
        }
        if(button.getId().equals("Disaster5"))
        {
            option=5;
            if(arr[5]==1)
            {
                switchtoPrevDisaster(e, 5);
            }
            else {
                switchtoNewDisaster(e, 5);
            }
        }
    }

    public void erase(ActionEvent e)
    {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;
        Button button = (Button) e.getSource();

        try {

            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/status", "farhan", "henloworld");

            if (button.getId().equals("erase1")) {
                psInsert = connection.prepareStatement("update disasterStatus set disaster1=0;");
                psInsert.executeUpdate();
            }
            else if (button.getId().equals("erase2")) {
                psInsert = connection.prepareStatement("update disasterStatus set disaster2=0;");
                psInsert.executeUpdate();
            }
            else if (button.getId().equals("erase3")) {
                psInsert = connection.prepareStatement("update disasterStatus set disaster3=0;");
                psInsert.executeUpdate();

            }
            else if (button.getId().equals("erase4")) {
                psInsert = connection.prepareStatement("update disasterStatus set disaster4=0;");
                psInsert.executeUpdate();

            }
            else if(button.getId().equals("erase5")){
                psInsert = connection.prepareStatement("update disasterStatus set disaster5=0;");
                psInsert.executeUpdate();
            }


        }
        catch (SQLException i)
        {
            i.printStackTrace();
        }

        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("disaster.fxml"));
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(newRoot);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }


    }

}
