package com.dojo.projectone;

public class BatTest {

	public BatTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Bat bat = new Bat();
		bat.fly().eatHumans().attackTown().eatHumans().fly();
		bat.displayEnergy();
	}

}
