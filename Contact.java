package com.projectone.contact;

public class Contact {
	
	private String ID; // must be unique, 10 chars max - not null - Cannot Change / update
	private String firstName; // 10 chars max - not null
	private String lastName; // 10 chars max - not null
	private String number; // Phone number - 10 digits max - not null
	private String address; // 30 Chars max- not null

	// Default Constructor
	public Contact(String ID, String firstName, String lastName, String number, String address) {
		
		// Using setter methods to check for valid criteria
		this.setID(ID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setNumber(number);
		this.setAddress(address);
	
	}

	public String getID() {
		return this.ID;
	}
	// Set to private so it can't be changed once it is set
	private void setID(String ID) {
		if (ID == null  || ID.length() > 10 || ID.trim() == "") {
			throw new IllegalArgumentException("Invalid ID.");
		}

		this.ID = ID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		if (firstName == null || firstName.length() > 10 || firstName.trim() == "") {
			throw new IllegalArgumentException("Invalid First Name.");
		}
		
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws IllegalArgumentException{
		if (lastName == null || lastName.length() > 10 || lastName.trim() == "") {
			throw new IllegalArgumentException("Invalid Last Name.");
		}

		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) throws IllegalArgumentException{
		if (number == null || number.length() > 10 || number.trim() == "") {
			throw new IllegalArgumentException("Invalid Phone Number.");
		}		
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30 || address.trim() == "" ) {
			throw new IllegalArgumentException("Invalid Address.");
		}
		
		this.address = address;
	}
	

}
