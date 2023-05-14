package com.example.disastermanagementsystemfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddWorker implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int option=0;

    @FXML
    public TextField name;
    @FXML
    public TextField contact;
    @FXML
    public TextField email;
    @FXML
    public TextField address;
    @FXML
    public TextField gender;
    @FXML
    public TextField age;
    @FXML
    public TextField id;
    @FXML
    public TextField salary;
    @FXML
    private TextField availability;
    @FXML
    public ChoiceBox<String> skill;

    String nam, cont, em, addr, gen, ID,ag,av, sal;
    @FXML
    public void Worker(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("supportDetails.fxml"));
        root = loader.load();
        supportDetailsController controller = (supportDetailsController) loader.getController();
        controller.setType(option);
        controller.init();
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }




    void getValue()
    {
        nam=name.getText();
        cont=contact.getText();
        em=email.getText();
        addr=address.getText();
        gen=gender.getText();
        ag=age.getText();
        ID = id.getText();
        av=availability.getText();
        sal=salary.getText();

    }

    public void SetValues() throws IOException {

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
            Parent root = FXMLLoader.load(getClass().getResource("SupportDetails.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public TextField getAvailability() {
        return availability;
    }

    public void setAvailability(TextField availability) {
        this.availability = availability;
    }
}
