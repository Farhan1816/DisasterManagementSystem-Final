package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PrevDisasterCasualtiesController implements Initializable {

    public static int option;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label Death, Injured, Hospitalised;

    private int death, injured, hospitalised, residenceDestroyed, loss;

    @FXML
    private Button AddDeath, InfoDeath, AddInjured, InfoInjured, AddHospitalised, InfoHospitalised, EnterResidence, EnterLoss;

    @FXML
    private TextField EconomicLoss, ResidenceDestroyed;


    public PrevDisasterCasualtiesController(int val)
    {
        option = val;
        //System.out.println(option);
    }

    public void addInjured(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInjuredPopUp.fxml"));
        Parent root = loader.load();
        AddInjured addInjured= loader.getController();
        addInjured.init(option);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addDeath(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDeathPopUp.fxml"));
        Parent root = loader.load();
        AddDeath addDeath= loader.getController();
        addDeath.init(option);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void enterResidence(ActionEvent e) {
        String val = ResidenceDestroyed.getText();
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;
        try {
            if (option == 1)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster1", "farhan", "henloworld");
            else if (option == 2)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan", "henloworld");
            else if (option == 3)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan", "henloworld");
            else if (option == 4)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan", "henloworld");
            else if (option == 5)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan", "henloworld");

            psInsert = connection.prepareStatement("set sql_safe_updates=0;");
            psInsert.executeUpdate();
            psInsert = connection.prepareStatement("update casualties set ResidenceDestroyed=?;");
            psInsert.setInt(1, Integer.valueOf(val));
            psInsert.executeUpdate();

        }
        catch (SQLException i)
        {
            i.printStackTrace();
        }

        residenceDestroyed = Integer.valueOf(val);
        ResidenceDestroyed.setText(val);
    }

    public void enterLoss(ActionEvent e) {
        String val = EconomicLoss.getText();
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;
        try {
            if (option == 1)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster1", "farhan", "henloworld");
            else if (option == 2)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan", "henloworld");
            else if (option == 3)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan", "henloworld");
            else if (option == 4)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan", "henloworld");
            else if (option == 5)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan", "henloworld");

            psInsert = connection.prepareStatement("set sql_safe_updates=0;");
            psInsert.executeUpdate();
            psInsert = connection.prepareStatement("update casualties set Loss=?;");
            psInsert.setInt(1, Integer.valueOf(val));
            psInsert.executeUpdate();
        }
        catch (SQLException i)
        {
            i.printStackTrace();
        }

        loss = Integer.valueOf(val);
        EconomicLoss.setText(val);
    }

    public PrevDisasterCasualtiesController()
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

            psCheck= connection.prepareStatement("select * from casualties");

            resultSet = psCheck.executeQuery();
            while (resultSet.next())
            {
                death = resultSet.getInt(1);
                Death.setText(Integer.toString(death));
                injured = resultSet.getInt(2);
                Injured.setText(Integer.toString(injured));
                hospitalised = resultSet.getInt(3);
                Hospitalised.setText(Integer.toString(hospitalised));
                residenceDestroyed = resultSet.getInt(4);
                System.out.println(residenceDestroyed);
                ResidenceDestroyed.setText(Integer.toString(residenceDestroyed));
                loss = resultSet.getInt(5);
                System.out.println(loss);
                EconomicLoss.setText(Integer.toString(loss));
            }

            //System.out.println(option + " " + death + " " + injured+ " " + hospitalised+ " " +residenceDestroyed+" "+loss);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
