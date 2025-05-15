package com.example.session08.model;

public class FarmerUser {
    private int farmerId;
    private String farmerName;
    private String farmerPass;
    private String farmerEmail;
    private double wallet = 10000;

    public FarmerUser() {
    }
    public FarmerUser(int farmerId, String farmerName, String farmerPass, String farmerEmail) {
        this.farmerId = farmerId;
        this.farmerName = farmerName;
        this.farmerPass = farmerPass;
        this.farmerEmail = farmerEmail;
    }
    // Getters và Setters

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerPass() {
        return farmerPass;
    }

    public void setFarmerPass(String farmerPass) {
        this.farmerPass = farmerPass;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
