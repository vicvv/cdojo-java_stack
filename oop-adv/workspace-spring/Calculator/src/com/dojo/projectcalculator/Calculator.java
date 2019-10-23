package com.dojo.projectcalculator;

public class Calculator {
	
	private double operOne;
	private double operTwo;
	private String operation;
	private double result;

	public Calculator(double one, double two, String operation) {
		setOperOne(one);
		setOperTwo(two);
		setOpration(operation);
		
	}
	
	public void setOperOne(double operOne) {
		this.operOne = operOne;
	}
	public void setOperTwo(double operTwo) {
		this.operTwo = operTwo;
	}
	
	public void setOpration(String operation) {
		if(operation == "+" || operation == "-") {
			this.operation = operation;
		}
		else {
			System.err.println("invalid operation!");
		}
	}
	
	
	public double getOp1() {
		return this.operOne;
	}
	
	public double getOp2() {
		return this.operTwo;
	}
	public String getOperation() {
		return this.operation;
	}
	
	
	public double performOperation() {
		
		if (getOperation() == "-") {
			
			this.result = this.operOne - this.operTwo;
			
		} else {
			this.result = this.operOne + this.operTwo;
		}
		
		return this.result;
		
	}
	
	public void printResult() {
		System.out.println("The result of operation is: " + this.result);
	}
	
	

}
