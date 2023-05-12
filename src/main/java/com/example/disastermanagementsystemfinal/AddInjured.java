package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

public class AddInjured {

    int option;

    @FXML
    TextField Name, Contact, Email, Address, Gender, Age, Injury, ShelterNo, DoctorID;
    @FXML
    Button Enter;

    String name, contact, email, address, gender, age, injury, shelterNo, doctor;

    InjuredOrSick newInjured;

    void getValue()
    {
        name = Name.getText();
        contact = Contact.getText();
        email = Email.getText();
        address = Address.getText();
        gender = Gender.getText();
        age = Age.getText();
        injury = Injury.getText();
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
            psInsert = connection1.prepareStatement("delete from injured;");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("insert into injured(NameInj, Contact, Email, Address, Gender, Age, Injury, shelterNo, doctorID) values(?,?,?,?,?,?,?,?,?)");
            psInsert.setString(1, name);
            psInsert.setString(2, contact);
            psInsert.setString(3, email);
            psInsert.setString(4, address);
            psInsert.setString(5, gender);
            psInsert.setString(6, age);
            psInsert.setString(7, injury);
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
        try
        {
            getValue();
            SetValues();
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
    }




}
