package com.dojo.projectphone;

public class PhoneTest {

	public PhoneTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {		
		IPhone ip = new IPhone("Z", 200, "Verizon", "Rings!");
		Galaxy ga = new Galaxy("G",200,"Verizon", "Rings!");
		
		ip.displayInfo();
		ip.ring();
		ip.unlock();
				
		ga.displayInfo();
	}

}
