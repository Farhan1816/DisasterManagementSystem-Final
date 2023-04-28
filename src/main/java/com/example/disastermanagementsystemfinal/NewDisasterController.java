package com.example.disastermanagementsystemfinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewDisasterController implements Initializable {

    @FXML
    private ChoiceBox<String>disasterType;

    @FXML
    private ChoiceBox<String>intensityType, district;

    private String[] disasters= {"Cyclone", "Drought", "Earthquake", "Flood",  "Fire", "Storm", "Tornado"};
    private String[] intensitys= {"Low", "Moderate", "High"};

    private String[] districts = {"Dhaka", "Faridpur", "Gazipur", "Gopalganj" ,"Kishoreganj", "Madaripur" , "Manikganj" ,"Munshiganj","Narayanganj" ,"Narsingdi" ,"Rajbari", "Shariatpur", "Tangail" ,"District", "Cumilla", "Chattogram" ,"Chandpur", "Brahmanbaria", "Bandarban", "Noakhali", "Lakshmipur" , "Khagrachhari", "Feni", "Cox’s Bazar" ,"Rangamati","Sylhet" , "Sunamganj" ,"Moulvibazar","Habiganj", "Patuakhali", "Jhalokati", "Bhola", "Barishal", "Barguna" ,"Pirojpur","Khulna" ,"Jhenaidah", "Jashore" ,"Chuadanga" ,"Bagerhat" ,"Satkhira" ,"Narail", "Meherpur" ,"Magura", "Kushtia", "Chapainawabganj" ,"Natore", "Joypurhat" ,"Naogaon" ,"Bogura", "Sirajganj", "Rajshahi", "Pabna","Dinajpur" ,"District" ,"Gaibandha", "Rangpur", "Panchagarh", "Nilphamari", "Lalmonirhat", "Kurigram", "Thakurgaon","Sherpur", "Netrokona", "Mymensingh", "Jamalpur"};



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        disasterType.getItems().addAll(disasters);
        intensityType.getItems().addAll(intensitys);
        district.getItems().addAll(districts);
    }


}
