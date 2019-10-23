package com.dojo.projectphone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "ring";
    }
    @Override
    public String unlock() {
        return "unlocked";
    }
    @Override
    public void displayInfo() {
        // your code here            
    }
}

