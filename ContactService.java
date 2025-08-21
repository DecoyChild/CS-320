package com.projectone.contact;

import java.util.HashMap;
import com.projectone.contact.Contact;

public class ContactService {
	
	public HashMap<String, Contact> contactsMap = new HashMap<String, Contact>();
	
	public ContactService() {
		
	}
	
	// Add a new Contact 
	public void addNewContact(String ID, String firstName, String lastName, String number, String address) throws IllegalArgumentException{
		if (this.contactsMap.containsKey(ID)) {
			throw new IllegalArgumentException("ID Already Exists");
		}
		Contact newContact = new Contact(ID,firstName,lastName,number,address);
		this.contactsMap.put(newContact.getID(), newContact);
	}
	
	// If the ID exists remove it from the list
	public void deleteContactByID(String ID) {
		if (!this.contactsMap.containsKey(ID)) {
			throw new IllegalArgumentException("ID " + ID + " was not found");
		}
		this.contactsMap.remove(ID);
	}
	
	// Update the existing Contacts information
	public void updateContactFirstName(String ID, String firstName)   {
		if (!this.contactExists(ID)) {
			throw new IllegalArgumentException("ID " + ID + " was not found");
		}
		Contact currentContract = this.contactsMap.get(ID);
		currentContract.setFirstName(firstName);
		this.contactsMap.put(ID,currentContract);
	}
	
	public void updateContactLastName(String ID, String lastName) {
		if (!this.contactExists(ID)) {
			throw new IllegalArgumentException("ID " + ID + " was not found");
		}
		Contact currentContract = this.contactsMap.get(ID);
		currentContract.setLastName(lastName);
		this.contactsMap.put(ID,currentContract);
	}
	
	public void updateContactNumber(String ID,String number) {
		if (!this.contactExists(ID)) {
			throw new IllegalArgumentException("ID " + ID + " was not found");
		}
		Contact currentContract = this.contactsMap.get(ID);
		currentContract.setNumber(number);
		this.contactsMap.put(ID,currentContract);
	}
	
	public void updateContactAddress(String ID,String address) {
		if (!this.contactExists(ID)) {
			throw new IllegalArgumentException("ID " + ID + " was not found");
		}
		Contact currentContract = this.contactsMap.get(ID);
		currentContract.setAddress(address);
		this.contactsMap.put(ID,currentContract);
	}
	
	
	// Checking to see if the ID exists in the map
	private boolean contactExists(String ID) {
		return this.contactsMap.containsKey(ID);
	}
}
