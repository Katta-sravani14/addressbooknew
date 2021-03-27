package sravani.addressbookuc4;

import java.util.Scanner;

public class Contact {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String email;
	private int zipCode;
	private long phoneNumber;
	
	public static Scanner personContact = new Scanner(System.in);
	
	public Contact(String firstName, String lastName, String address, String city, String state, String email,
			int zipCode, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void creatingContact() {
		System.out.println("Enter your first name : ");
		setFirstName(personContact.next());
		System.out.println("Enter your last name : ");
		setLastName(personContact.next());
		System.out.println("Enter your address : ");
		setAddress(personContact.nextLine());
		setAddress(personContact.nextLine());
		System.out.println("Enter your city : ");
		setCity(personContact.next());
		System.out.println("Enter your State : ");
		setState(personContact.next());
		System.out.println("Enter your zip code : ");
		setZipCode(personContact.nextInt());
		System.out.println("Enter your phone number : ");
		setPhoneNumber(personContact.nextLong());
		System.out.println("Enter your email address : ");
		setEmail(personContact.next());

	}
	
	@Override
	public String toString() {
		return "[firstName =" + firstName + ", lastName =" + lastName + ", city =" + city + ", state =" + state
				+ ", zip =" + zipCode + ", phone =" + phoneNumber + ", email address =" + email + "]\n";
	}
	
}