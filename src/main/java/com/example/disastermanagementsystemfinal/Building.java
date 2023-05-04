package com.example.disastermanagementsystemfinal;

import java.util.*;
import java.util.PrimitiveIterator.OfInt;

public abstract class Building {
    String name, adress;
    Building(String name, String adress){
        this.adress=adress;
        this.name=name;
    }

    void ChangeAdress(String name, String adress){
        this.adress=adress;
        this.name=name;
    }
}

class EmergencyShelter extends Building{
    int shelterNo, capacity, remainSlot, bookedSlot, areaInKM, condition;
    String supportingArea;
    boolean seatAvailability=true;
    String buildingDetail="Habitable";

    EmergencyShelter(String name, String adress, int shelterNo, int capacity, int bookedSlot, int areaInKM, int condition, String supportingArea){
        super(name, adress);
        this.shelterNo=shelterNo;
        this.capacity=capacity;
        this.bookedSlot=bookedSlot;
        this.areaInKM=areaInKM;
        this.condition=condition;
        if(this.condition<=2){
            this.buildingDetail="Inhabitable!!";
        }
        this.supportingArea=supportingArea;
        this.remainSlot=this.capacity-this.bookedSlot;
        if(this.remainSlot>=5){
            this.seatAvailability=true;
        }

    }

    void AddPeople(int addPeople){
        this.bookedSlot+=addPeople;
        this.remainSlot-=addPeople;
        if(this.remainSlot>=5){
            this.seatAvailability=true;
        }
    }

    void CapacityUP(int capInc){
        this.remainSlot+=capInc;
        if(this.remainSlot>=5){
            this.seatAvailability=true;
        }
    }

    void FreeCap(int subPeople){
        this.bookedSlot-=subPeople;
        this.remainSlot+=subPeople;
        if(this.remainSlot>=5){
            this.seatAvailability=true;
        }
    }

    void ConditionUP(int condition){
        this.condition=condition;
        if(condition<=2){
            this.buildingDetail="Inhabitable!!";
        }
    }

    void UpgradeCon(){
        this.condition=4;
        if(condition<=2){
            this.buildingDetail="Habitable";
        }
    }

}

class DisasterOffice extends Building{
    int officeNo, areaInKM, totalSupportTeam;
    int supportRequest, supportGiven;
    int totalFundInArea,totalFoodGrain,totalFoodPackage,totalWaterInLiter;
    String workingingArea;

    DisasterOffice(String name, String adress, int officeNo, int areaInKM, int totalSupportTeam, int supportRequest, int supportGiven, String workingArea){
        super(name, adress);
        this.officeNo=officeNo;
        this.workingingArea=workingArea;
        this.areaInKM=areaInKM;
        this.totalSupportTeam=totalSupportTeam;
        this.supportRequest=supportRequest;
        this.supportGiven=supportGiven;
    }

    void SupportRequestUp(int newReq){
        this.supportRequest+=newReq;
    }

    void SupportGivenUp(int newGiv){
        this.supportGiven+=newGiv;
    }
}

class Pharmacy extends Building{
    int pharmaNo, medicineRequested, kitRequested, medicineReceived, kitReceived;
    String pharmaName;

    Pharmacy(String name, String adress, String pharmaName, int pharmaNo, int medicineRequested, int kitRequested, int medicineReceived, int kitReceived){
        super(name, adress);
        this.pharmaName=pharmaName;
        this.pharmaNo=pharmaNo;
    }
}
