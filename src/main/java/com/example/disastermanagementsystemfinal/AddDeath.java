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

    Dead newDead;

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
    String name, contact, email, address, gender, age, death, shelterNo, doctor;



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
        newDead= new Dead(name, contact, email, address, gender, Integer.valueOf(age), Integer.valueOf(shelterNo),doctor,death);

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
            psInsert.setString(1, newDead.name);
            psInsert.setString(2, newDead.contact);
            psInsert.setString(3, newDead.email);
            psInsert.setString(4, newDead.address);
            psInsert.setString(5, newDead.gender);
            psInsert.setString(6, Integer.toString(newDead.age));
            psInsert.setString(7, newDead.deathCause);
            psInsert.setString(8, Integer.toString(newDead.shelterNo));
            psInsert.setString(9, newDead.treatedByPersonID);

            psInsert.executeUpdate();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void update()
    {
        Connection connection1 = null, connection2=null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;

        try {
            if (option == 1) {
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster1", "farhan", "henloworld");
            } else if (option == 2) {
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan", "henloworld");
            } else if (option == 3) {
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan", "henloworld");
            } else if (option == 4) {
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan", "henloworld");
            } else if (option == 5) {
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan", "henloworld");
            }

            psInsert = connection1.prepareStatement("set sql_safe_updates=0");
            psInsert.executeUpdate();
            Statement stmt = connection1.createStatement();
            String sql = "select Deaths from casualties LIMIT 1";
            ResultSet rs =stmt.executeQuery(sql);
            int deathValue=0;
            if(rs.next())
            {
                deathValue = rs.getInt(1);
            }

            deathValue++;
            System.out.println(deathValue);
            psInsert = connection1.prepareStatement("update casualties set Deaths=? where 1=1");
            psInsert.setInt(1, deathValue);
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("update disaster set death=? where 1=1");
            psInsert.setInt(1, deathValue);
            psInsert.executeUpdate();
        }

        catch(SQLException i)
        {
            i.printStackTrace();
        }
    }

    public void confirmed(ActionEvent e)
    {
        System.out.println(option);
        try
        {
            getValue();
            SetValues();
            update();
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
