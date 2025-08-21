package com.projectone.contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.projectone.contact.Contact;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contact = new Contact("123","Shayne","Greene","6035551234","23 Main Street Somewhere");
		assertTrue(contact.getID().equals("123"));
		assertTrue(contact.getFirstName().equals("Shayne"));
		assertTrue(contact.getLastName().equals("Greene"));
		assertTrue(contact.getNumber().equals("6035551234"));
		assertTrue(contact.getAddress().equals("23 Main Street Somewhere"));
	}
	
	// Not Null ******************************************
	@Test
	void testContactIDNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null,"Shayne","Greene","6035551234","23 Main Street Somewhere");
		});}

	@Test
	void testContactFirstNameNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234",null,"Greene","6035551234","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactLastNameNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne",null,"6035551234","23 Main Street Somewhere");
		});}
	@Test
	
	void testContactNumberNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","Greene",null,"23 Main Street Somewhere");
		});}
	
	@Test
	void testContactAddressNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","Greene","6035551234",null);
		});}
	
	// String too long tests  ******************************************
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910","Shayne","Greene","6035551234","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne_123456","Greene","6035551234","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactLirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","GreeneGreene","6035551234","23 Main Street Somewhere");
		});}
	@Test
	
	void testContactNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","Greene","6035551234123","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","Greene","6035551234","23 Main Street Somewhere but not from Here");
		});}

	// Blank entries ******************************************
	@Test
	void testContactIDBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("","Shayne","Greene","6035551234","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactFirstNameBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","","Greene","6035551234","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactLirstNameBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","","6035551234","23 Main Street Somewhere");
		});}
	@Test
	
	void testContactNumberBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","Greene","","23 Main Street Somewhere");
		});}
	
	@Test
	void testContactAddressBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234","Shayne","Greene","6035551234","");
		});}
}
