package sravani.addressbookuc3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystemMain<listOfContact, personContact, listOfContact1> {
	public static Scanner personContact = new Scanner(System.in);
	Contact contact = new Contact("firstName", "lastName", "address", "city", "state", "email address", 0, 0);
	ArrayList<Object> listOfContact = new ArrayList<>();

	public void takingOption() {
		System.out.println("Enter your option: ");
		System.out.println("1.Add Contact");
		System.out.println("2.Display Contacts");
		System.out.println("3.Edit an exixting contact");
		int option = personContact.nextInt();
		switch (option) {
		case 1:
			addingContact();
			break;
		case 2:
			displayContact();
			break;
		case 3:
			editContact();
		default:
			break;
		}
		takingOption();
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
		listOfContact.add(contact);
	}

	public void editContact() {
		System.out.println("Enter name for edit :");
		String name = personContact.next();
		for (int check = 0; check < listOfContact.size(); check++) {
			Contact contact = (Contact) listOfContact.get(check);
			if (name.equals(contact.getFirstName())) {
				System.out.println("Enter your new address : ");
				contact.setAddress(personContact.nextLine());
				contact.setAddress(personContact.nextLine());
				System.out.println("Enter your new city : ");
				contact.setCity(personContact.next());
				System.out.println("Enter your new State : ");
				contact.setState(personContact.next());
				System.out.println("Enter your new zip code : ");
				contact.setZipCode(personContact.nextInt());
				System.out.println("Enter your new phone number : ");
				contact.setPhoneNumber(personContact.nextLong());
				System.out.println("Enter your new email address : ");
				contact.setEmail(personContact.next());
				listOfContact.add(contact);
			} else
				System.out.println("There is no data exist by this name");
		}
	}

	public void displayContact() {
		System.out.println(listOfContact);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to address book system");
		AddressBookSystemMain contactDetails = new AddressBookSystemMain();
		contactDetails.takingOption();
	}

}