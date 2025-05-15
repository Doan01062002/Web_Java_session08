package com.example.session08.model;

public class CropSeed {
    private int seedId;
    private String seedName;
    private double seedPrice;
    private String seedImage;

    public CropSeed() {
    }

    public CropSeed(int seedId, String seedName, double seedPrice, String seedImage) {
        this.seedId = seedId;
        this.seedName = seedName;
        this.seedPrice = seedPrice;
        this.seedImage = seedImage;
    }

    // Getters và Setters

    public int getSeedId() {
        return seedId;
    }

    public void setSeedId(int seedId) {
        this.seedId = seedId;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public double getSeedPrice() {
        return seedPrice;
    }

    public void setSeedPrice(double seedPrice) {
        this.seedPrice = seedPrice;
    }

    public String getSeedImage() {
        return seedImage;
    }

    public void setSeedImage(String seedImage) {
        this.seedImage = seedImage;
    }
}
