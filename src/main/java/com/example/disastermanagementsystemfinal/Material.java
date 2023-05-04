package com.example.disastermanagementsystemfinal;

import java.util.*;
import java.util.PrimitiveIterator.OfInt;

public abstract class Material {
    static int totalAmmountOfDonation=0, totalAmmountDistributedOrCosting=0;
    Calendar receiveDate;
    static Calendar today;
    Material(){
        this.receiveDate= Calendar.getInstance();
    }

    void timeUpdate(){
        Material.today= Calendar.getInstance();
    }
}

class Fund extends Material{

    static int totalFundAmmount=0,distBetweenPeopleTotal=0;

    int ammountInTK=0, officeNo;
    int donationType;
    String donationBy;
    boolean distributionStatus=false;

    int distAmmount, remainAmmount, distBetweenPeopleCount=0;

    Fund(int donationType, String donationBy, int ammountInTK, int officeNo)
    {
        super();

        Fund.totalFundAmmount=Fund.totalFundAmmount+this.ammountInTK;
        this.officeNo=officeNo;
        this.donationType=donationType;
        this.ammountInTK=ammountInTK;
        this.donationBy=donationBy;
        this.distributionStatus=false;

        Material.totalAmmountOfDonation+=this.ammountInTK;
    }

    void AddFund(int addFund){
        this.ammountInTK+=addFund;
        Fund.totalFundAmmount+=addFund;
        Material.totalAmmountOfDonation+=addFund;
        this.distributionStatus=false;
    }

    void Distribute(int distAmmount, int distBetweenPeopleCount){
        this.distAmmount=distAmmount;
        Material.totalAmmountDistributedOrCosting+=distAmmount;
        this.remainAmmount=this.ammountInTK-this.distAmmount;
        if(remainAmmount==0){
            this.distributionStatus=true;
        }
        this.distBetweenPeopleCount=distBetweenPeopleCount;
        Fund.distBetweenPeopleTotal+=this.distBetweenPeopleCount;
    }
}

class FirstAidKit extends Material
{
    static int totalKit=0,wholeprice=0;
    static int ammountInTK=0;
    String kitUsability="Usable";
    String brandName, workerID;
    int kitQuantity, pharmaNo, condition, kitPrice=0,kitTotalPrice;
    boolean availability;
    FirstAidKit(String brandName, int kitPrice, int kitQuantity, String workerID, int pharmaNo, int condition, boolean availability)
    {
        super();

        FirstAidKit.totalKit=FirstAidKit.totalKit+this.kitQuantity;
        this.brandName=brandName;
        this.kitQuantity=kitQuantity;
        this.workerID=workerID;
        this.kitPrice=kitPrice;
        this.kitTotalPrice=this.kitPrice*this.kitQuantity;
        FirstAidKit.wholeprice=FirstAidKit.wholeprice+kitTotalPrice;
        this.pharmaNo=pharmaNo;
        this.condition=condition;
        this.availability=availability;

        Material.totalAmmountOfDonation+=this.ammountInTK;
    }

    void AddQuantity(int addQuantity){
        this.kitQuantity+=addQuantity;
        this.kitTotalPrice+=addQuantity*this.kitPrice;
        Material.totalAmmountOfDonation+=addQuantity*kitPrice;
    }

    void Availability(boolean availability){
        this.availability=availability;
    }
    //condition int range 1-5: 1-veryBad, 2-bad, 3-avr, 4-good, 5-excellent
    void ConditionUp(int condition){
        this.condition=condition;
        if(this.condition<=2){
            this.kitUsability="Unusable!!";
        }
    }

    void PriceChange(int newPrice){
        int diff=newPrice-this.kitPrice;
        this.kitPrice=newPrice;
        this.kitTotalPrice+=this.kitQuantity*diff;
        FirstAidKit.wholeprice+=this.kitQuantity*diff;
        Material.totalAmmountOfDonation+=this.kitQuantity*diff;
    }

    void UpgradeTool(int costing, int quantity){
        Material.totalAmmountDistributedOrCosting+=costing*quantity;
        FirstAidKit.wholeprice+=costing*quantity;
        this.kitUsability="Usable";
    }

    void NewUser(String workerID){
        this.workerID=workerID;
    }
}

class Medicine extends Material
{
    static double totalMedicineCost=0;
    int donationType;
    String donationBy;
    String name, brandName, groupName, expiryStatus="unexpired";
    Calendar expiryDate= Calendar.getInstance();
    Calendar manufacturerDate;
    int quantity,pharmaNo;
    boolean availability;
    double pricePerUnit,priceInTotal;

    Medicine(String name,String brandName, String groupName, int quantity, int donationType, String donationBy, Calendar manufacturerDate, int pharmaNo, double pricePerUnit, int lifeSpanInMonth, boolean availabilty)
    {
        super();

        this.name=name;
        this.brandName=brandName;
        this.groupName=groupName;
        this.donationType=donationType;
        this.donationBy=donationBy;
        this.quantity=quantity;
        this.pharmaNo=pharmaNo;
        this.pricePerUnit=pricePerUnit;

        Medicine.totalMedicineCost=Medicine.totalMedicineCost+priceInTotal;
        this.priceInTotal=this.pricePerUnit*this.quantity;
        this.availability=availabilty;
        this.manufacturerDate=manufacturerDate;
        this.expiryDate=manufacturerDate;

        int month,year;
        month=lifeSpanInMonth%12;
        year=lifeSpanInMonth/12;

        expiryDate.add(Calendar.MONTH,month);
        expiryDate.add(Calendar.YEAR,year);
        if(this.expiryDate.compareTo(Material.today)>0){
            expiryStatus="Expired!!";
        }
    }

    void QuantityUp(int addQuantity){
        this.quantity=this.quantity+addQuantity;
        this.priceInTotal=this.priceInTotal+addQuantity*this.pricePerUnit;
        Medicine.totalMedicineCost=Medicine.totalMedicineCost+addQuantity*this.pricePerUnit;
    }

    void PricePerUnitChange(int pricePerUnit){
        this.pricePerUnit=pricePerUnit;
        Medicine.totalMedicineCost=Medicine.totalMedicineCost-priceInTotal;
        this.priceInTotal=this.pricePerUnit*this.quantity;
        Medicine.totalMedicineCost=Medicine.totalMedicineCost+priceInTotal;

    }

    void Availability(boolean availability){
        this.availability=availability;
    }
}

abstract class FoodRelief extends Material{
    String foodCon="Edible";

    static int totalFoodCost=0;

    int donationInfo, officeNo;
    String donationBy;
    boolean availability;
    int distQuantity, distBetweenPeopleCount, remainQuantity, distributionStatus=0;
    static int quantity=0;

    double price;
    Calendar validity;

    FoodRelief(int donationInfo, String donationBy, int officeNo, boolean availability, int distributionStatus, Calendar validity){
        super();
        this.donationInfo=donationInfo;
        this.donationBy=donationBy;
        this.officeNo=officeNo;
        this.availability=availability;
        this.distributionStatus=distributionStatus;
        this.validity=validity;
        this.price=0;

        if(this.validity.compareTo(Material.today)>0){
            this.foodCon="Inedible!!";
        }
    }

    void Distribute(int distQuantity, int distBetweenPeopleCount){
        this.distQuantity=distQuantity;
        Material.totalAmmountDistributedOrCosting+=this.distQuantity*this.price;
        this.remainQuantity=this.quantity-this.distQuantity;
        if(remainQuantity==0){
            this.distributionStatus=1;
        }
        this.distBetweenPeopleCount=distBetweenPeopleCount;
        Fund.distBetweenPeopleTotal+=this.distBetweenPeopleCount;
    }

    void Wasted(){
        this.foodCon="Inedible!!";
    }
}

class FoodOrGrain extends FoodRelief{

    static double totalWholePrice=0;
    static  int distBetweenPeopleTotal;

    String foodOrGrainType;
    int quantity;
    double pricePerUnit, priceInTotal;

    static Calendar foodValidity;

    FoodOrGrain(int donationInfo, String donationBy, int officeNo, boolean availability, String foodOrGrainType, int quantity, int validityInDay, double pricePerUnit){
        super(donationInfo, donationBy, officeNo, availability, 0, foodValidity);
        this.foodOrGrainType=foodOrGrainType;
        this.quantity=quantity;
        this.pricePerUnit=pricePerUnit;

        this.foodValidity=this.receiveDate;
        foodValidity.add(Calendar.DATE, validityInDay);

        this.priceInTotal=this.pricePerUnit*this.quantity;
        FoodOrGrain.totalWholePrice=FoodOrGrain.totalWholePrice+this.priceInTotal;
        Material.totalAmmountOfDonation+=this.priceInTotal;
    }
}

class FoodPackage extends FoodRelief{
    static double totalWholePrice=0;
    static  int distBetweenPeopleTotal;

    int quantity;
    double pricePerUnit, priceInTotal;
    static Calendar foodValidity;

    FoodPackage(int donationInfo, String donationBy, int officeNo, boolean availability, int quantity, int validityInDay, double pricePerUnit){
        super(donationInfo, donationBy, officeNo, availability, 0, foodValidity);
        this.quantity=quantity;
        this.pricePerUnit=pricePerUnit;

        this.foodValidity=this.receiveDate;
        foodValidity.add(Calendar.DATE, validityInDay);

        this.priceInTotal=this.pricePerUnit*this.quantity;
        FoodPackage.totalWholePrice=FoodPackage.totalWholePrice+this.priceInTotal;
        Material.totalAmmountOfDonation+=this.priceInTotal;
    }

}

class WaterSupply extends FoodRelief{
    static int totalWholePrice=0, distBetweenPeopleTotal;

    String supplierOrBrand;

    int quantityInLiter;
    double pricePerUnit, priceInTotal;
    static Calendar foodValidity;

    WaterSupply(int donationInfo, String donationBy, String supplierOrBrand, int officeNo, boolean availability, int quantityInLiter, double pricePerUnit){
        super(donationInfo, donationBy, officeNo, availability, 0, foodValidity);
        this.quantityInLiter=quantityInLiter;
        this.pricePerUnit=pricePerUnit;
        this.supplierOrBrand=supplierOrBrand;
        this.foodValidity=this.receiveDate;
        foodValidity.add(Calendar.YEAR,1);

        this.priceInTotal=this.pricePerUnit*this.quantityInLiter;
        FoodPackage.totalWholePrice=FoodPackage.totalWholePrice+this.priceInTotal;
        Material.totalAmmountOfDonation+=this.priceInTotal;
    }

}

