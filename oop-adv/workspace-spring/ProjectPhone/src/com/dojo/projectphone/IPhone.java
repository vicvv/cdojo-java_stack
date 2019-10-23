package com.dojo.projectphone;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "ring";
    }
    @Override
    public String unlock() {
        return "unlock";
    }
    @Override
    public void displayInfo() {
        // your code here            
    }
}

