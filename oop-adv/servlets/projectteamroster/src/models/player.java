package models;

public class player {
	
	private String fname;
	private String lname;
	private Integer age;
	
	public player() {
						
	}
	
	public player(String fname, String lname, Integer age) {
		
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public String getLname() {
		return this.lname;
	}
	
	public Integer getAge() {
		return this.age;
	}

}
