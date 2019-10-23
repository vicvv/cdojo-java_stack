package com.dojo.projectcalculator;

public class CalculatorTest {

//	public CalculatorTest() {
//		// TODO Auto-generated constructor stub
//	}

	public static void main(String[] args) {
		
		Calculator c = new Calculator(25.5, 3.5, "-");
		c.performOperation();
		c.printResult();

	}

}
