package com.dojo.objecttest;

public class HumanTest {

	public HumanTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Human h1 = new Human();
		Human h2 = new Human();
		h1.attack(h2);
		h2.printHealth();
		

	}

}
