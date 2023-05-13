package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class AddDeath {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int option=0;
    public AddDeath(int val)
    {
        option=val;
    }

    public AddDeath()
    {

    }

    public void init(int val)
    {
        option = val;
    }

    @FXML
    TextField Name, Contact, Email, Address, Gender, Age, DeathCause, ShelterNo, DoctorID;
    @FXML
    Button Enter;

    String name, contact, email, address, gender, age, death, shelterNo, doctor, hospital;


    void getValue()
    {
        name = Name.getText();
        contact = Contact.getText();
        email = Email.getText();
        address = Address.getText();
        gender = Gender.getText();
        age = Age.getText();
        death = DeathCause.getText();
        shelterNo= ShelterNo.getText();
        doctor=DoctorID.getText();

    }

    public void SetValues()
    {
        System.out.println(option);
        Connection connection1 = null, connection2=null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;

        try {
            connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/status", "farhan", "henloworld");
            if(option==1) {
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster1", "farhan","henloworld");
            }
            else if(option==2){
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan","henloworld");
            }
            else if(option==3){
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan","henloworld");
            }
            else if(option==4){
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan","henloworld");
            }
            else if(option==5){
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan","henloworld");
            }
            psInsert = connection1.prepareStatement("set sql_safe_updates=0;");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("insert into death(Namedth, Contact, Email, Address, Gender, Age, Death , ShelterNo, DoctorID) values(?,?,?,?,?,?,?,?,?)");
            psInsert.setString(1, name);
            psInsert.setString(2, contact);
            psInsert.setString(3, email);
            psInsert.setString(4, address);
            psInsert.setString(5, gender);
            psInsert.setString(6, age);
            psInsert.setString(7, death);
            psInsert.setString(8, shelterNo);
            psInsert.setString(9, doctor);

            psInsert.executeUpdate();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void confirmed(ActionEvent e)
    {
        System.out.println(option);
        try
        {
            getValue();
            SetValues();
            back(e);
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
    }

    public void back(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DisasterCasualties.fxml"));
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
