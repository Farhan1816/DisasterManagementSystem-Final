package com.example.disastermanagementsystemfinal;

abstract public class Person {
    String name, contact, email, address, gender;
    int age;
    Person(String name, String contact, String email, String address, String gender, int age)
    {
        this.name=name;
        this.contact=contact;
        this.email=email;
        this.address=address;
        this.gender=gender;
        this.age=age;
    }
}



class Doctor extends Person{

    String speciality, medicalCollege, workingPlace;
    Doctor(String name, String contact, String email, String address, String gender, int age, String speciality, String medicalCollege, String workingPlace)
    {
        super(name, contact, email, address, gender, age);
        this.speciality=speciality;
        this.medicalCollege=medicalCollege;
        this.workingPlace=workingPlace;
    }

}

class DisasterOfficer extends Person{

    String workingPlace;
    int supportTeam;
    DisasterOfficer(String name, String contact, String email, String address, String gender, int age, String workingPlace, int supportTeam)
    {
        super(name, contact, email, address, gender, age);
        this.workingPlace=workingPlace;
        this.supportTeam=supportTeam;
    }
}

class ReliefWorker extends Person{

    String workingPlace;
    ReliefWorker(String name, String contact, String email, String address, String gender, int age, String workingPlace, int supportTeam)
    {
        super(name, contact, email, address, gender, age);
        this.workingPlace=workingPlace;
    }
}

