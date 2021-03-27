package sravani.addressbookuc2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystemMain<personContact, listOfContact> {
	public static Scanner personContact = new Scanner(System.in);
	Contact contact = new Contact("firstName", "lastName", "address", "city", "state", "email address", 0, 0);
	
	
	public void takingOption() {
		System.out.println("Enter your option: ");
		System.out.println("1.Add Contact");
		System.out.println("2.Display Contacts");
		int option = personContact.nextInt();
		switch(option) {
		case 1:
			addingContact();
			break;
		case 2:
			displayContact();
			break;
		default:
			break;
		}
		takingOption();
	}
	private void displayContact() {
		// TODO Auto-generated method stub
		
	}
	public void addingContact() {
		contact.creatingContact();
		contact.getFirstName();
		contact.getLastName();
		contact.getAddress();
		contact.getCity();
		contact.getState();
		contact.getEmail();
		contact.getZipCode();
		contact.getPhoneNumber();
		
	}



	public static void main(String[] args) {
		System.out.println("Welcome to address book system");
		AddressBookSystemMain contactDetails = new AddressBookSystemMain();
		contactDetails.takingOption();
	}

}