package com.example.disastermanagementsystemfinal;

import javafx.beans.property.SimpleStringProperty;

public class datamodel {

    private final String firstName;
    private final String lastName;

    public datamodel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
