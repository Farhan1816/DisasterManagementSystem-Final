package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PrevDisasterController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int option;
    public PrevDisasterController(int value)
    {
        option=value;
    }

    public PrevDisasterController()
    {

    }


    @FXML
    private Label Type, Location, Deaths, Injured, Hospitalised, Residence, EconomicLoss, Doctors, ReliefWorkers, Volunteers;
    String type, location;
    int deaths, injured, hospitalised, residence, economicloss, doctors, reliefworkers, volunteers;

    public void Printvals()
    {
        System.out.println(option);
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;
        System.out.println(option);

        try{
            if(option==1)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster1", "farhan","henloworld");
            else if(option==2)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan","henloworld");
            else if(option==3)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan","henloworld");
            else if(option==4)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan","henloworld");
            else if(option==5)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan","henloworld");

            psCheck= connection.prepareStatement("select * from disaster");

            resultSet = psCheck.executeQuery();
            while (resultSet.next())
            {
                type = resultSet.getString(1);
                Type.setText(type);
                location = resultSet.getString(2);
                Location.setText(location);
                deaths = resultSet.getInt("death");
                Deaths.setText(String.valueOf(deaths));
                injured = resultSet.getInt("injured");
                Injured.setText(String.valueOf(injured));
                economicloss = resultSet.getInt("economic_loss");
                EconomicLoss.setText(String.valueOf(economicloss));
                hospitalised = resultSet.getInt("hospitalised");
                Hospitalised.setText(String.valueOf(hospitalised));
                residence = resultSet.getInt("residenceDestroyed");
                Residence.setText(String.valueOf(residence));
                doctors= resultSet.getInt("doctors");
                Doctors.setText(String.valueOf(doctors));
                reliefworkers = resultSet.getInt("relief_workers");
                ReliefWorkers.setText(String.valueOf(reliefworkers));
                volunteers = resultSet.getInt("volunteers");
                Volunteers.setText(String.valueOf(volunteers));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void  initData(int val)
    {
        System.out.println("hello");
        option = val;
        System.out.println(option);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Printvals();
    }

    public void logout(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene((root));
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
    }

    public void back(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("disaster.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene((root));
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
    }

}
