package com.project.service;

import java.util.Scanner;

import com.project.model.Contact;
import com.project.model.Phonebook;
import com.project.model.Validate;


public class MyClass {

	public static void main(String[] args)  throws Validate{
		Scanner sc = new Scanner(System.in);
		Phonebook phonebook = new Phonebook();
		while(true) {
			System.out.println("1. Add Contact");
			System.out.println("2. Search Contact");
			System.out.println("3. Update Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Display all Contacts");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int ch = sc.nextInt();
			sc.nextLine();
			try {
			switch(ch) {
			case 1:
				System.out.print("Enter Name: ");
				String name1 =sc.nextLine();
				System.out.print("Enter Phone number: ");
				String number1 =sc.nextLine();
				if(!number1.matches("\\d+")) {
                	throw new Validate("phone number contain digits only");
                }
                if(number1.length() !=10) {
                	throw new Validate("phone number must be length of 10");
                }
				phonebook.addContact(new Contact(name1,number1));
				break;
			case 2:
				while(true) {
					System.out.println("a. Search by name");
					System.out.println("b. Search by number");
					System.out.println("c. Exit");
					System.out.print("Enter choice: ");
					String subCh = sc.nextLine();
					switch(subCh) {
					case "a":
						System.out.print("Enter name: ");
						String nm = sc.nextLine();
						phonebook.searchContact(nm);
						break;
					case "b":
						System.out.print("Enter number: ");
						String num = sc.nextLine();
						phonebook.searchByNumber(num);
						break;
					case "c":
						break;
					default:
						System.out.println("Invalid choice!");
						break;
					}
					break;
				}
				break;
			case 3:
				while(true) {
					System.out.println("a. Update name");
					System.out.println("b. Update number");
					System.out.println("c. Exit");
					String subCh = sc.nextLine();
					switch(subCh) {
					case "a":
						System.out.print("Enter Old name: ");
						String oldName = sc.nextLine();
						System.out.print("Enter New name: ");
						String newName = sc.nextLine();
						phonebook.updateContactName(oldName, newName);
						break;
					case "b":
						System.out.print("Enter Name: ");
						String name3 = sc.nextLine();
						System.out.print("Enter number:");
						String num3 = sc.nextLine();
						phonebook.updateContactNumber(name3, num3);
						break;
					case "c":
						break;
					default:
						System.out.println("Invalid choice!");
						break;
					}
					break;
				}
				break;
			case 4:
				System.out.print("Enter Name to delete: ");
				String name4 = sc.nextLine();
				phonebook.deleteContact(name4);
				break;
			case 5:
				phonebook.displayAll();
				break;
			case 6:
				System.out.println("Terminated Successfully");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
			}}catch(Validate e) {
				System.out.println(e.getMessage());
			}
		}  
			
	}
}
	
	


