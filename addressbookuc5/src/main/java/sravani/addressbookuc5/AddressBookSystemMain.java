package sravani.addressbookuc5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystemMain {
	public static Scanner personContact = new Scanner(System.in);
	Contact contact = new Contact("firstName", "lastName", "address", "city", "state", "email address", 0, 0);
	List<Object> listOfContact = new ArrayList<>();

	public void takingOption() {
		System.out.println("Enter your option: ");
		System.out.println("1.Add Contact");
		System.out.println("2.Display Contacts");
		System.out.println("3.Edit an exixting contact");
		System.out.println("4.Delete an existing contact");
		System.out.println("5.Exit");
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
			break;
		case 4:
			deleteContact();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			break;
		}
		takingOption();

	}

	public void addingContact() {
		 Contact contact = new Contact("firstName", "lastName", "address", "city",
		 "state", "email address", 0, 0);
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
		int flag = 0;
		for ( int check =0; check<listOfContact.size(); check++) {
			Contact contact = (Contact)listOfContact.get(check);
			if (name.equals(contact.getFirstName())) {
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("There is contact by this nane");
		}else {
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
			} 	
	}

	public void displayContact() {
		System.out.println(listOfContact);
	}

	public void deleteContact() {
		System.out.println("Enter name for delete that contact");
		String name = personContact.next();
		for (int person = 0; person < listOfContact.size(); person++) {
			Contact contact = (Contact) listOfContact.get(person);
			if (name.equals(contact.getFirstName())) {
				listOfContact.remove(person);
			} else
				System.out.println("There is no data exist by this name");
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to address book system");
		AddressBookSystemMain contactDetails = new AddressBookSystemMain();
		contactDetails.takingOption();
	}

}