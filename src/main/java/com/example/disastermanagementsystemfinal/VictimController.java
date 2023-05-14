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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class VictimController extends Controller implements Initializable {

    public int option=0;
    private Stage stage;
    private Scene scene;
    private Parent root;

   @FXML
   private Button Disaster1, Disaster2, Disaster3, Disaster4, Disaster5;

   @FXML
   private Label Location1, Location2, Location3, Location4, Location5, Date1, Date2, Date3, Date4, Date5;

    private  int arr[]= new int[10];

    public void switchtoDisasterCasualties(ActionEvent event, int option) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterCasualties.fxml"));

        if(option==1 && arr[1]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(1);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(1);
        }
        else if(option==2 && arr[2]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(2);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(2);
        }
        else if(option==3 && arr[3]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(3);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(3);
        }
        else if(option==4 && arr[4]==1)
        {
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(4);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(4);
        }
        else if(option==5 && arr[5]==1){
            PrevDisasterCasualtiesController prevDisaster = new PrevDisasterCasualtiesController(5);
            loader.setController(null);
            loader.setLocation(getClass().getResource("DisasterCasualties.fxml"));
            //prevDisasterController.initData(5);
        }

        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchPage(ActionEvent e) throws IOException {
        Button button=(Button)e.getSource();

        if(button.getId().equals("Disaster1"))
        {
            if(arr[1]==1)
            {
                switchtoDisasterCasualties(e, 1);
            }
            option=1;
        }
        if(button.getId().equals("Disaster2"))
        {
            option=2;
            if(arr[2]==1)
            {
                switchtoDisasterCasualties(e, 2);
            }
        }
        if(button.getId().equals("Disaster3"))
        {
            option=3;
            if(arr[3]==1)
            {
                switchtoDisasterCasualties(e, 3);
            }
        }
        if(button.getId().equals("Disaster4"))
        {
            option=4;
            if(arr[4]==1)
            {
                switchtoDisasterCasualties(e, 4);
            }

        }
        if(button.getId().equals("Disaster5"))
        {
            option=5;
            if(arr[5]==1)
            {
                switchtoDisasterCasualties(e, 5);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = null, connection2=null;
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
                        modifyButton(i);
                    }

                    else {

                        String str = new String("N/A");
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

    public void back(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
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

    private void modifyButton(int option)
    {
        Connection connection = null, connection2=null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;

        try {
            if(option==1)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster1", "farhan","henloworld");
            else if(option==2)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster2", "farhan","henloworld");
            else if(option==3)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster3", "farhan","henloworld");
            else if(option==4)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster4", "farhan","henloworld");
            else if(option==5)connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Disaster5", "farhan","henloworld");

            psCheck= connection.prepareStatement("select * from disaster");
            resultSet = psCheck.executeQuery();

            if(resultSet.next()) {
                String disasterType = resultSet.getString(1);
                String district = resultSet.getString(4);
                String intensity = resultSet.getString(3);
                String date = resultSet.getString(5);


                if (option == 1) {
                    Disaster1.setText(disasterType);
                    Location1.setText(district);
                    Date1.setText(date);
                    if (intensity.equals("Low")) Disaster1.setStyle("-fx-background-color: #CDB7F6");
                    else if (intensity.equals("Moderate")) Disaster1.setStyle("-fx-background-color: #FED000");
                    else if (intensity.equals("High")) Disaster1.setStyle("-fx-background-color: B22222");
                } else if (option == 2) {
                    Disaster2.setText(disasterType);
                    Location2.setText(district);
                    Date2.setText(date);
                    if (intensity.equals("Low")) Disaster2.setStyle("-fx-background-color: #CDB7F6");
                    else if (intensity.equals("Moderate")) Disaster2.setStyle("-fx-background-color: #FED000");
                    else if (intensity.equals("High")) Disaster2.setStyle("-fx-background-color: B22222");

                } else if (option == 3) {
                    Disaster3.setText(disasterType);
                    Location3.setText(district);
                    Date3.setText(date);
                    if (intensity.equals("Low")) Disaster3.setStyle("-fx-background-color: #CDB7F6");
                    else if (intensity.equals("Moderate")) Disaster3.setStyle("-fx-background-color: #FED000");
                    else if (intensity.equals("High")) Disaster3.setStyle("-fx-background-color: B22222");
                } else if (option == 4) {
                    Disaster4.setText(disasterType);
                    Location4.setText(district);
                    Date4.setText(date);
                    if (intensity.equals("Low")) Disaster4.setStyle("-fx-background-color: #CDB7F6");
                    else if (intensity.equals("Moderate")) Disaster4.setStyle("-fx-background-color: #FED000");
                    else if (intensity.equals("High")) Disaster4.setStyle("-fx-background-color: B22222");
                } else if (option == 5) {
                    Disaster5.setText(disasterType);
                    Location5.setText(district);
                    Date5.setText(date);
                    if (intensity.equals("Low")) Disaster5.setStyle("-fx-background-color: #CDB7F6");
                    else if (intensity.equals("Moderate")) Disaster5.setStyle("-fx-background-color: #FED000");
                    else if (intensity.equals("High")) Disaster5.setStyle("-fx-background-color: B22222");
                }
            }
        }
        catch(Exception i)
        {
            i.printStackTrace();
        }
    }


}


