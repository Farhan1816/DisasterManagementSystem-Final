package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.sql.*;

public class NewDisasterController extends Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public int option = 0;

    @FXML
    private ChoiceBox<String>DisasterType;

    @FXML
    private ChoiceBox<String>Intensity;
    @FXML
    private TextField Location;


    @FXML
    private ChoiceBox<String>District;

    @FXML
    private DatePicker ApproximateDate;

    @FXML
    private TextField ApproximateTime;

    @FXML
    private Button Confirm;



    private String[] disasters= {"Cyclone", "Drought", "Earthquake", "Flood",  "Fire", "Storm", "Tornado"};
    private String[] intensitys= {"Low", "Moderate", "High"};

    private String[] districts = {"Dhaka", "Faridpur", "Gazipur", "Gopalganj" ,"Kishoreganj", "Madaripur" , "Manikganj" ,"Munshiganj","Narayanganj" ,"Narsingdi" ,"Rajbari", "Shariatpur", "Tangail" ,"District", "Cumilla", "Chattogram" ,"Chandpur", "Brahmanbaria", "Bandarban", "Noakhali", "Lakshmipur" , "Khagrachhari", "Feni", "Cox’s Bazar" ,"Rangamati","Sylhet" , "Sunamganj" ,"Moulvibazar","Habiganj", "Patuakhali", "Jhalokati", "Bhola", "Barishal", "Barguna" ,"Pirojpur","Khulna" ,"Jhenaidah", "Jashore" ,"Chuadanga" ,"Bagerhat" ,"Satkhira" ,"Narail", "Meherpur" ,"Magura", "Kushtia", "Chapainawabganj" ,"Natore", "Joypurhat" ,"Naogaon" ,"Bogura", "Sirajganj", "Rajshahi", "Pabna","Dinajpur" ,"District" ,"Gaibandha", "Rangpur", "Panchagarh", "Nilphamari", "Lalmonirhat", "Kurigram", "Thakurgaon","Sherpur", "Netrokona", "Mymensingh", "Jamalpur"};

    String type, location, district, date, time, intensity;
    int injured, death, hospitalised, residenceDestroyed, economicLoss, doctors, relief_workers, volunteers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DisasterType.getItems().addAll(disasters);
        Intensity.getItems().addAll(intensitys);
        District.getItems().addAll(districts);
    }

    public void initData(int val)
    {
        option = val;
    }

    public void confirmed(ActionEvent event) throws IOException
    {
        GetValues();
        SetValues();
        back(event);
        reset();
    }

    public void GetValues()
    {
        type= DisasterType.getValue();
        location = Location.getText();
        district = District.getValue();
        LocalDate local=ApproximateDate.getValue();
        local = ApproximateDate.getValue();
        date = local.toString();
        time = ApproximateTime.getText();
        intensity=Intensity.getValue();
        injured=0;
        death=0;
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
                psInsert = connection2.prepareStatement("set sql_safe_updates=0;");
                psInsert.executeUpdate();
                psInsert = connection2.prepareStatement("update disasterStatus set disaster1=1;");
                psInsert.executeUpdate();
            }
            else if(option==2){
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan","henloworld");
                psInsert = connection2.prepareStatement("set sql_safe_updates=0;");
                psInsert.executeUpdate();
                psInsert = connection2.prepareStatement("update disasterStatus set disaster2=1;");
                psInsert.executeUpdate();
            }
            else if(option==3){
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan","henloworld");
                psInsert = connection2.prepareStatement("set sql_safe_updates=0;");
                psInsert.executeUpdate();
                psInsert = connection2.prepareStatement("update disasterStatus set disaster3=1;");
                psInsert.executeUpdate();
            }
            else if(option==4){
                connection1= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan","henloworld");
                psInsert = connection2.prepareStatement("set sql_safe_updates=0;");
                psInsert.executeUpdate();
                psInsert = connection2.prepareStatement("update disasterStatus set disaster4=1;");
                psInsert.executeUpdate();
            }
            else{
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan","henloworld");
                psInsert = connection2.prepareStatement("set sql_safe_updates=0;");
                psInsert.executeUpdate();
                psInsert = connection2.prepareStatement("update disasterStatus set disaster5=1;");
                psInsert.executeUpdate();
            }
            psInsert = connection1.prepareStatement("set sql_safe_updates=0;");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("delete from disaster;");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("insert into disaster(disaster_type, location, intensity, district, approximate_date, approximate_time, injured, death, hospitalised, residenceDestroyed, economic_loss, doctors, relief_workers, volunteers) values(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0)");
            psInsert.setString(1, type);
            psInsert.setString(2, location);
            psInsert.setString(3, intensity);
            psInsert.setString(4, district);
            psInsert.setString(5, date);
            psInsert.setString(6, time);
            psInsert.setInt(7, injured);
            psInsert.setInt(8, death);

            psInsert.executeUpdate();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }



    }

    public void reset()
    {
        System.out.println(option);
        Connection connection1 = null, connection2=null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;

        try {
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
            else{
                connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan","henloworld");
            }
            psInsert = connection1.prepareStatement("set sql_safe_updates=0;");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("delete from death");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("delete from injured");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("delete from casualties");
            psInsert.executeUpdate();
            psInsert = connection1.prepareStatement("insert into casualties(Deaths, Injured, Hospitalised, ResidenceDestroyed, Loss) values(0, 0, 0, 0, 0)");
            psInsert.executeUpdate();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
