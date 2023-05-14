package com.example.disastermanagementsystemfinal;

import javax.xml.transform.sax.TemplatesHandler;

abstract public class Person {
    static int personCount=0;
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

    void AddressUp(String address){
        this.address=address;
    }

    void ContactUp(String contact){
        this.contact=contact;
    }

    void EmailUp(String email){
        this.email=email;
    }
}



class Doctor extends Person{
    //doctor id start with 01-2023(YEAR)-******;
    static int doctorCount=0;

    String speciality, medicalCollege, workingPlace, id, qualification;
    int appointmentType;
    int salary=0;
    boolean availabilty;
    Doctor(String name, String contact, String email, String address, String gender, int age, String id, String qualification, String speciality, String medicalCollege, int appointmentType, String workingPlace, boolean availability)
    {

        super(name, contact, email, address, gender, age);

        Person.personCount++;
        Doctor.doctorCount++;

        this.id=id;
        this.qualification=qualification;
        this.speciality=speciality;
        this.medicalCollege=medicalCollege;
        this.appointmentType=appointmentType;
        this.workingPlace=workingPlace;
        this.availabilty =availability;
    }

    void Salary(int salary){
        this.salary=salary;
    }

    void Availability(boolean availability){
        this.availabilty=availability;
    }

    void Transfer(String workingPlace, boolean availability){
        this.workingPlace=workingPlace;
        this.availabilty=availability;
    }
}

class DisasterOfficer extends Person{
    //doctor id start with 02-2023(YEAR)-******;
    static int disasterOfficerCount=0;

    String workingPlace, id, designation;
    int supportTeam, officeNo, salary;
    boolean availability;
    DisasterOfficer(String name, String contact, String email, String address, String gender, int age, String id, String designation, int salary, String workingPlace, int officeNo, int supportTeam, boolean availability)
    {
        super(name, contact, email, address, gender, age);

        Person.personCount++;
        disasterOfficerCount++;

        this.id=id;
        this.salary=salary;
        this.designation=designation;
        this.officeNo=officeNo;
        this.workingPlace=workingPlace;
        this.supportTeam=supportTeam;
        this.availability=availability;
    }

    void Salary(int salary){
        this.salary=salary;
    }

    void Transfer(String workingPlace, int officeNo, int supportTeam){
        this.workingPlace=workingPlace;
        this.officeNo=officeNo;
        this.supportTeam=supportTeam;
        this.availability=availability;
    }

    void Promote(String designation, String workingPlace, int officeNo, int supportTeam){
        this.designation=designation;
        this.workingPlace=workingPlace;
        this.officeNo=officeNo;
        this.supportTeam=supportTeam;
        this.availability=availability;
    }
}

class ReliefWorker extends Person{
    //doctor id start with 03-2023(YEAR)-******;
    static int workerCount=0;

    String workingPlace, id, speciality;
    String workingStatus="Working";
    int appointmentType, supportTeam;
    int salary=0;
    boolean availabilty, engagedStatus;
    ReliefWorker(String name, String contact, String email, String address, String gender, int age, String id, String speciality, int appointmentType, String workingPlace, int supportTeam, boolean engagedStatus, boolean availability)
    {
        super(name, contact, email, address, gender, age);

        Person.personCount++;
        ReliefWorker.workerCount++;

        this.id=id;
        this.speciality=speciality;
        this.appointmentType=appointmentType;
        this.workingPlace=workingPlace;
        this.supportTeam=supportTeam;
        this.availabilty=availability;
        this.engagedStatus=engagedStatus;
    }

    void Salary(int salary){
        this.salary=salary;
    }

    void EngagedUp(boolean engageStatus){
        this.engagedStatus= engagedStatus;
    }

    void Availability(boolean availability){
        this.availabilty=availability;
    }

    void Transfer(String workingPlace, int supportTeam, boolean availability){
        this.workingPlace=workingPlace;
        this.supportTeam=supportTeam;
        this.availabilty=availability;
    }

    void Fired(){
        this.availabilty=false;
        this.engagedStatus=false;
        this.workingStatus="Fired";

    }
}

class Victim extends Person{

    static int victimCount=0;

    int  shelterNo, bil=0,payType, paid, due, financialSupport=0;
    boolean treatInfo=false;

    String treatedByPersonID;
    String supportRequestDetail;

    String hospital;

    Victim(String name, String contact, String email, String address, String gender, int age,  int shelterNo, String treatedByPersonID)
    {
        super(name, contact, email, address, gender, age);

        Victim.victimCount++;
        this.shelterNo=shelterNo;
        this.treatedByPersonID= treatedByPersonID;

    }

    void finSup(int financialSupport){
        this.financialSupport=financialSupport;
    }

    void BilUp(int bil){
        this.bil=bil;
    }

    void PayUp(int paid){
        this.paid=paid;
        this.due=this.bil-this.paid;
    }

    void TreatUp(boolean treatInfo){
        this.treatInfo=treatInfo;
    }
}

class InjuredOrSick extends Victim{
    static int injuredCount=0;

    String hospital;
    int severity;
    String sicknessDetail;
    String treatedByPersonID ;
    InjuredOrSick(String name, String contact, String email, String address, String gender, int age,int shelterNo, String treatedByPersonID, String sicknessDetail, String hospital){
        super(name, contact, email, address, gender, age,  shelterNo, treatedByPersonID);

        injuredCount++;

        this.sicknessDetail=sicknessDetail;
        this.hospital=hospital;
    }

    void severityUp(int severity){
        this.severity=severity;
    }

}

class Dead extends Victim{
    static int deathCount=0;
    int bodyClaimedStatus;
    String deathCause;
    Dead(String name, String contact, String email, String address, String gender, int age, int shelterNo, String treatedByPersonID, String deathCause){
        super(name, contact, email, address, gender, age,  shelterNo, treatedByPersonID);

        deathCount++;
        this.deathCause=deathCause;
    }

    void ClaimingStatusUp(int bodyClaimedStatus){
        this.bodyClaimedStatus=bodyClaimedStatus;
    }

}