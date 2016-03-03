package main.java;



// Created by Devin Byrne

public class Person {
	
	private String firstName, lastName, address, city, state, ZIP, phone;
	private int ID;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZIP() {
		return ZIP;
	}

	public String getPhone() {
		return phone;
	}

	public Person(int ID, String firstName, String lastName, String address, String city, String state, String ZIP, String phone) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.ZIP = ZIP;
		this.phone = phone;
	}
	
	public void personUpdate(String address, String city, String state, String ZIP, String phone) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.ZIP = ZIP;
		this.phone = phone;
	}

	public int getID() {
		return ID;
	}

	

}
