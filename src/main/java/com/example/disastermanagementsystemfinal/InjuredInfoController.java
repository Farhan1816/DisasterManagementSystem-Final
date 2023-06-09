package com.example.disastermanagementsystemfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class InjuredInfoController extends Controller implements Initializable {

    @FXML
    private Label Contact, Email, Address, Gender, Age, InjuryDetails , ShelterNo, DoctorID, Hospital;
    @FXML
    private Button Logout, Back, enter;
    @FXML
    private ChoiceBox<String>Name;

    private String name, contact, email, address, gender, age, shelterNo, doctorID, injury, hospital;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int option;

    InjuredOrSick prevSick;

    public InjuredInfoController(int val)
    {
        option = val;
    }

    public InjuredInfoController()
    {

    }

    public void enterName(ActionEvent e)
    {
        name = Name.getValue();
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
            String query = "SELECT * FROM injured WHERE NameInj = ?";
            Statement stmt = connection1.createStatement();
            PreparedStatement pstmt = connection1.prepareStatement(query);
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                contact = rs.getString(2);
                email = rs.getString(3);
                address = rs.getString(4);
                gender = rs.getString(5);
                age = rs.getString(6);
                injury =rs.getString(7);
                shelterNo = rs.getString(8);
                doctorID = rs.getString(9);
                hospital = rs.getString(10);

                System.out.println(doctorID);
            }

            prevSick= new InjuredOrSick(name,contact,email,address, gender,Integer.valueOf(age),Integer.valueOf(shelterNo),doctorID,injury,hospital);

            Contact.setText(prevSick.contact);
            Email.setText(prevSick.email);
            Address.setText(prevSick.address);
            Gender.setText(prevSick.gender);
            Age.setText(Integer.toString(prevSick.age));
            InjuryDetails.setText(injury);
            ShelterNo.setText(Integer.toString(prevSick.shelterNo));
            DoctorID.setText(doctorID);
            Hospital.setText(prevSick.hospital);

        }
        catch (SQLException i)
        {
            i.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            String sql = "SELECT NameInj FROM injured";
            Statement stmt = connection1.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ObservableList<String> dataList = FXCollections.observableArrayList();
            while(rs.next()){
                String data = rs.getString("NameInj");
                dataList.add(data);
            }
            Name.setItems(dataList);
        }

        catch (SQLException e)
        {
            e.printStackTrace();
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
