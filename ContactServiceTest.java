package com.projectone.contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.projectone.contact.ContactService;


class ContactServiceTest {

	// rem --- Testing creating of Contact Service Object 
	@Test
	void testContactServiceClass() {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		
		assertTrue(contactService.contactsMap.get("123").getID().equals("123"));
		assertTrue(contactService.contactsMap.get("123").getFirstName().equals("Shayne"));
		assertTrue(contactService.contactsMap.get("123").getLastName().equals("Greene"));
		assertTrue(contactService.contactsMap.get("123").getNumber().equals("6035551234"));
		assertTrue(contactService.contactsMap.get("123").getAddress().equals("23 Main Street Somewhere"));
	}
	
	// rem -- Test the deletion of a contact
	@Test 
	void testDelete(){
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.deleteContactByID("123");
	}
	
	@Test
	void testAddDuplicate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			ContactService newContactService = new ContactService();  
			newContactService.addNewContact("123","Just","Testing","6035551234","23 Main Street Somewhere");
			
		});}
	
	@Test
	void testFailedDelete() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.deleteContactByID("456");
		});}
	
	// rem --- testing the update fields
	@Test
	void testUpdateFirstName() {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactFirstName("123", "Peeta");
		assertTrue(contactService.contactsMap.get("123").getFirstName().equals("Peeta"));
	}
	@Test
	void testUpdateFirstNameBadID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactFirstName("1234", "Peeta");
		assertTrue(contactService.contactsMap.get("1234").getFirstName().equals("Peeta"));
	});}
	
	@Test
	void testUpdateLastName() {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactLastName("123", "Mellark");
		assertTrue(contactService.contactsMap.get("123").getLastName().equals("Mellark"));
	}
	
	@Test
	void testUpdateLastNameBadID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactLastName("1234", "Mellark");
		assertTrue(contactService.contactsMap.get("1234").getLastName().equals("Mellark"));
	});}
	
	@Test
	void testUpdateNumber() {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactNumber("123", "555123456");
		assertTrue(contactService.contactsMap.get("123").getNumber().equals("555123456"));
	}
	@Test
	void testUpdateNumberBadID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactNumber("1234", "555123456");
		assertTrue(contactService.contactsMap.get("1234").getNumber().equals("555123456"));
		});}
	
	@Test
	void testUpdateAddress() {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactAddress("123", "District 12");
		assertTrue(contactService.contactsMap.get("123").getAddress().equals("District 12"));
	}
	@Test
	void testUpdateAddressBadID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		ContactService contactService = new ContactService();  
		contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		contactService.updateContactAddress("1234", "District 12");
		assertTrue(contactService.contactsMap.get("1234").getAddress().equals("District 12"));
	});}
	
	// REM --- Test update values to NULL
	@Test
	void testUpdateFirstNameToNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactFirstName("123", null);
		});}
	
	@Test
	void testUpdateLastNameToNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactLastName("123", null);
		});}
	
	@Test
	void testUpdateNumberToNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactNumber("123", null);
		});}
	
	@Test
	void testUpdateAddressToNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactAddress("123", null);
		});}
	
	// REM --- Test Update Values Length
	@Test
	void testUpdateFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactFirstName("123", "Peeta_Peeta");
		});}
	
	@Test
	void testUpdateLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactLastName("123", "Mellark_Mellark");
		});}
	
	@Test
	void testUpdateNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactNumber("123", "123456789456123");
		});}
	
	@Test
	void testUpdateAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();  
			contactService.addNewContact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
			contactService.updateContactAddress("123", "District 12 456789456123 NowheresVille" );
		});}

}
