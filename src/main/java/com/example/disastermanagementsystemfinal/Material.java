package com.example.disastermanagementsystemfinal;

public abstract class Material {
    int ammount = 0;
}

class Fund extends Material{
    String donationBy;
    String ID;
    Fund(String donationBy, int ammount)
    {
        this.ammount=ammount;
        this.donationBy=donationBy;
        this.ID=ID;
    }
}

class firstAidKit extends Material
{
    String ID, brandName;
    firstAidKit(String ID, String brandName)
    {
        this.ID=ID;
        this.brandName=brandName;
    }
}

class Medicine extends Material
{
    String ID, name, expiryDate, brand;
    double price;

    Medicine(String ID, String name, String expiryDate, String brand, double price, int ammount)
    {
        this.ID=ID;
        this.name=name;
        this.expiryDate=expiryDate;
        this.brand=brand;
        this.price=price;
        this.ammount=ammount;
    }
}

