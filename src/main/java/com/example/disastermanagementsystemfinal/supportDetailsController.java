package com.example.disastermanagementsystemfinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class supportDetailsController implements Initializable {

    @FXML
    private TableView<datamodel> DoctorTable;
    @FXML
    private TableView<datamodel> WorkerTable;
    @FXML
    private TableView<datamodel> volunteerTable;
    @FXML
    private TableView<datamodel> officerTable;
    @FXML
    private TableView<datamodel> victimTable ;
    @FXML
    private Label doctorLabel;
    @FXML
    private Label workerLabel;
    @FXML
    private  Label totalOfficer;
    @FXML
    private  Label totalVictim;
    @FXML
    private Label totalVolunteer ;

    @FXML
    private TableColumn<datamodel, String> doctorFirstNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> doctorLastNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> workerFirstNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> workerLastNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> volunteerFirstNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> volunteerLastNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> victimFirstNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> victimLastNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> officerFirstNameTableColumn;
    @FXML
    private TableColumn<datamodel, String> officerLastNameTableColumn;

    String[] fName = {"John", "Emily", "Michael", "Sophia", "Emma", "William", "Olivia", "Daniel", "Liam", "Isabella", "Mia", "Ethan", "Ava", "Noah", "Charlotte", "Alexander", "Elijah", "Harper", "Mason", "Luna"};
    String[] lName = {"David", "Lucy", "Matthew", "Grace", "Luke", "Chloe", "Isaac", "Elizabeth", "Gabriel", "Anna", "Zoe", "Caleb", "Lily", "Samuel", "Hannah", "Benjamin", "Evelyn", "Ezra", "Mila", "Nathan"};
    String[] fName1 = {"Ryan", "Avery", "Ben", "Jasmine", "Brandon", "Aria", "Tristan", "Natalie", "Adrian", "Samantha", "Aiden", "Audrey", "Alex", "Lila", "Blake", "Brooklyn", "Cole", "Penelope", "Connor", "Madeline"};
    String[] lName1 = {"Miles", "Maggie", "Gavin", "Elle", "Owen", "Paige", "Eli", "Caroline", "Jake", "Mackenzie", "Jackson", "Victoria", "Zachary", "Hailey", "Max", "Katherine", "Levi", "Aaliyah", "Noel", "Rebecca"};
    String[] fName2 = {"Leo", "Hazel", "Seth", "Eleanor", "Landon", "Amelia", "Nolan", "Maya", "Maxwell", "Makayla", "Jude", "Sophie", "Archer", "Claire", "Maddox", "Ruby", "Hudson", "Ivy", "Parker", "Esme"};
    String[] lName2 = {"Cameron", "Bella", "Adam", "Kaylee", "Cooper", "Julia", "Joshua", "Violet", "Christian", "Naomi", "Colin", "Alice", "Eric", "Molly", "Henry", "Sarah", "Isaiah", "Lucia", "Kevin", "Sienna"};
    String[] fName3 = {"Justin", "Savannah", "Kyle", "Skylar", "Marcus", "Ellie", "Mason", "Aubrey", "Nathaniel", "Taylor", "Nicholas", "Jenna", "Peter", "Abigail", "Xavier", "Genesis", "Travis", "Riley", "Vincent", "Zara"};
    String[] lName3 = {"Timothy", "Aurora", "Frank", "Daisy", "Victor", "Brielle", "Derek", "Emilia", "Edgar", "Leah", "George", "Avery", "Jared", "Annabelle", "Trevor", "Bridgette", "Spencer", "Jocelyn", "Tony", "Lydia"};
    String[] fName4 = {"Dean", "Malia", "Silas", "Zelda", "Lucas", "Bianca", "Wesley", "Delilah", "Gideon", "Gracie", "Calvin", "Tessa", "Nelson", "Eliza", "Arthur", "Iris", "Cody", "Jasmine", "Jayden", "Summer"};
    String[] lName4 = {"Yui", "Haruka", "Sakura", "Ayumi", "Kaito", "Akira", "Takumi", "Kazuhiro", "Satoshi", "Makoto", "Riko", "Shiori", "Mai", "Nana", "Ren", "Koki", "Hiroki", "Tsubasa", "Kenta", "Yuma"};

    String[] FNAME = {"Yuki", "Miku", "Haru", "Kaito", "Yui"};
    String[] LNAME = {"Sato", "Tanaka", "Ito", "Suzuki", "Watanabe"};

    String[] FNAME1 = {"Hikaru", "Akari", "Ren", "Kazuki", "Nana"};
    String[] LNAME1 = {"Nakamura", "Kato", "Yamamoto", "Saito", "Yoshida"};

    String[] FNAME2 = {"Sora", "Aki", "Riku", "Akira", "Rina"};
    String[] LNAME2 = {"Ishida", "Kobayashi", "Kawasaki", "Nishimura", "Matsuda"};

    String[] FNAME3 = {"Haruka", "Tatsuya", "Mao", "Shinichi", "Maki"};
    String[] LNAME3 = {"Yamada", "Kondo", "Sakamoto", "Nakajima", "Mori"};

    String[] FNAME4 = {"Aoi", "Sho", "Misaki", "Yuto", "Saki"};
    String[] LNAME4 = {"Iwamoto", "Fujimoto", "Takimoto", "Ishimoto", "Nakamoto"};
    int type;
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    void setType(int type) {
        this.type = type;
        System.out.println(type);
    }
    public void init()
    {
        try {
            doctorFirstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            doctorLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            workerFirstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            workerLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            victimFirstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            victimLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            officerFirstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            officerLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            volunteerFirstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            volunteerLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            ObservableList<datamodel> doctorData = FXCollections.observableArrayList();
            ObservableList<datamodel> workerData = FXCollections.observableArrayList();
            ObservableList<datamodel> victimData = FXCollections.observableArrayList();
            ObservableList<datamodel> officerData = FXCollections.observableArrayList();
            ObservableList<datamodel> volunteerData = FXCollections.observableArrayList();

            if(type == 1 )
            {
                for(int i = 0 ; i< fName.length ; i++) {
                    doctorData.add(new datamodel(fName[i], lName[i]));
                    victimData.add(new datamodel(fName[(i+3)%fName.length], lName[i])) ;
                    officerData.add(new datamodel(lName[i] , fName[i]));

                }
                for(int i = 0 ; i< FNAME.length; i++) {
                    workerData.add(new datamodel(FNAME[i], LNAME[i]));
                    volunteerData.add(new datamodel(FNAME[(i+2)%FNAME.length], LNAME[i])) ;

                }
                doctorLabel.setText(Integer.toString(fName.length));
                workerLabel.setText(Integer.toString(FNAME.length));
                totalVolunteer.setText(Integer.toString(FNAME.length));
                totalOfficer.setText(Integer.toString(fName.length));
                totalVictim.setText(Integer.toString(fName.length));


            }
            else if(type == 2)
            {
                for(int i = 0 ; i< fName1.length ; i++) {
                    doctorData.add(new datamodel(fName1[i], lName1[i]));
                    volunteerData.add(new datamodel(fName3[(i+2)%FNAME.length], fName1[i])) ;

                }
                for(int i = 0 ; i< FNAME1.length; i++) {
                    workerData.add(new datamodel(FNAME1[i], LNAME1[i]));
                    victimData.add(new datamodel(FNAME[(i+3)%FNAME.length], LNAME2[i])) ;
                    officerData.add(new datamodel(LNAME[i] , FNAME3[i]));

                }
                doctorLabel.setText(Integer.toString(FNAME1.length));
                workerLabel.setText(Integer.toString(FNAME1.length));
                totalVolunteer.setText(Integer.toString(fName.length));
                totalOfficer.setText(Integer.toString(FNAME.length));
                totalVictim.setText(Integer.toString(FNAME.length));
            }
            else if(type ==3 )
            {
                for(int i = 0 ; i< fName2.length ; i++) {
                    doctorData.add(new datamodel(fName2[i], lName2[i]));
                    victimData.add(new datamodel(fName[(i+3)%fName.length], lName[i])) ;
                    officerData.add(new datamodel(lName[i] , fName[i]));

                }
                for(int i = 0 ; i< FNAME2.length; i++) {
                    workerData.add(new datamodel(FNAME2[i], LNAME2[i]));
                    volunteerData.add(new datamodel(FNAME[(i+2)%FNAME.length], LNAME[i])) ;

                }
                doctorLabel.setText(Integer.toString(fName2.length));
                workerLabel.setText(Integer.toString(FNAME2.length));
                totalVolunteer.setText(Integer.toString(FNAME.length));
                totalOfficer.setText(Integer.toString(fName.length));
                totalVictim.setText(Integer.toString(fName.length));
            }
            else if(type == 4)
            {
                for(int i = 0 ; i< fName3.length ; i++) {
                    doctorData.add(new datamodel(fName3[i], lName3[i]));
                    volunteerData.add(new datamodel(fName[(i+2)%fName.length], fName1[i])) ;

                }
                for(int i = 0 ; i< FNAME3.length; i++) {
                    workerData.add(new datamodel(FNAME3[i], LNAME3[i]));
                    victimData.add(new datamodel(FNAME[(i+3)%FNAME.length], LNAME2[i])) ;
                    officerData.add(new datamodel(LNAME[i] , FNAME[i]));

                }
                doctorLabel.setText(Integer.toString(fName3.length));
                workerLabel.setText(Integer.toString(FNAME3.length));
                totalVolunteer.setText(Integer.toString(fName.length));
                totalOfficer.setText(Integer.toString(FNAME.length));
                totalVictim.setText(Integer.toString(FNAME.length));
            }
            else if(type == 5)
            {
                for(int i = 0 ; i< fName4.length ; i++) {
                    doctorData.add(new datamodel(fName4[i], lName4[i]));
                    victimData.add(new datamodel(fName[(i+3)%fName.length], lName[i])) ;
                    officerData.add(new datamodel(lName[i] , fName[i]));

                }
                for(int i = 0 ; i< FNAME4.length; i++) {
                    workerData.add(new datamodel(FNAME4[i], LNAME4[i]));
                    volunteerData.add(new datamodel(FNAME[(i+2)%FNAME.length], LNAME[i])) ;

                }
                doctorLabel.setText(Integer.toString(fName4.length));
                workerLabel.setText(Integer.toString(FNAME4.length));
                totalVolunteer.setText(Integer.toString(FNAME.length));
                totalOfficer.setText(Integer.toString(fName.length));
                totalVictim.setText(Integer.toString(fName.length));
            }

            DoctorTable.setItems(doctorData);
            WorkerTable.setItems(workerData);
            officerTable.setItems(officerData);
            volunteerTable.setItems(volunteerData);
            victimTable.setItems(victimData);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public  void returnToSupport(ActionEvent event ) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Support.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}