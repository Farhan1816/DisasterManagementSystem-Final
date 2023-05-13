package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AddInjured implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int option=0;
    public AddInjured(int val)
    {
        option=val;
    }

    public AddInjured()
    {

    }

    public void init(int val)
    {
        option = val;
    }

    @FXML
    TextField Name, Contact, Email, Address, Gender, Age, InjuryDetails, ShelterNo, DoctorID;
    @FXML
    Button Enter;
    @FXML
    ComboBox<String>Hospital;



    String name, contact, email, address, gender, age, injury, shelterNo, doctor, hospital;

    InjuredOrSick newInjured;

    void getValue()
    {
        name = Name.getText();
        contact = Contact.getText();
        email = Email.getText();
        address = Address.getText();
        gender = Gender.getText();
        age = Age.getText();
        injury = InjuryDetails.getText();
        shelterNo= ShelterNo.getText();
        doctor=DoctorID.getText();
        hospital=Hospital.getValue();
        if(!Hospital.getItems().contains(hospital)){
            Hospital.getItems().add(hospital);
        }
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
            psInsert = connection1.prepareStatement("insert into injured(NameInj, Contact, Email, Address, Gender, Age, Injury, shelterNo, doctorID, HospitalName) values(?,?,?,?,?,?,?,?,?,?)");
            psInsert.setString(1, name);
            psInsert.setString(2, contact);
            psInsert.setString(3, email);
            psInsert.setString(4, address);
            psInsert.setString(5, gender);
            psInsert.setString(6, age);
            psInsert.setString(7, injury);
            psInsert.setString(8, shelterNo);
            psInsert.setString(9, doctor);
            psInsert.setString(10, hospital);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Hospital.getItems().add("N/A");
        Hospital.setEditable(true);
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
