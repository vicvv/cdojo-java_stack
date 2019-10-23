package com.dojo.bankaccount;


//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//import java.text.DecimalFormat;



public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	private static int numOfAccounts = 0;
	private static double totMoney = 0;
	//DecimalFormat df = new DecimalFormat("#.00");

	public BankAccount() {
		numOfAccounts++;
		this.accountNumber = this.getAccountNumber();
		
	}
	
	//  Create a method that will allow a user to deposit money into either the checking or saving, 
	//  be sure to add to total amount stored.
	
	
	public void deposit(String acctype, int money) {
		if(acctype.equals("checking")) checkingBalance += money; 
		else savingBalance += money;
		
		this.totMoney += money;
	}
	
	public boolean  withdraw (String acctype, int money) {
		if (this.totMoney <= 0 & this.totMoney - money > 0) {
			return false;
		}
		else if(acctype.equals("checking")) {
			this.checkingBalance -= money; 
			this.totMoney -= money;
			return true;
			}
		else {
			this.savingBalance -= money; 
			this.totMoney -= money;
			return true;
			}
		
	}
	
	//  get balances
	public double getBalance(String acctype) {		
		if (acctype == "checking") return this.getCheckingBalance();	
		else return this.getSavingBalance();
	}
	
	// getters
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public double getSavingBalance() {
		return this.checkingBalance;
	}
	
	// helper
	private String genAccountNum() {
		
		int n = 10;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n); 
		  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 0 to AlphaNumericString variable length 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
	
	public String getAccountNumber() {		
		return this.genAccountNum();
	}
	
	
		
}
