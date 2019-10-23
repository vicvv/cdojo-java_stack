package com.dojo.objecttest;

public class DojosTest {

	public DojosTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Wizard w1 = new Wizard();
		Wizard w2 = new Wizard();
		
		Samurai s1 = new Samurai();
		Samurai s2 = new Samurai();
		
		Ninja n1 = new Ninja();
		Ninja n2 = new Ninja();
		
		w1.fireball(s1);
		w1.printHealth();
		s1.printHealth();
		
		

	}

}
