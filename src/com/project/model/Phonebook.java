package com.project.model;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
	Map<String,Contact> contacts = new HashMap<>();

	public void displayContact(Contact contact) {
		System.out.println("Name: "+contact.getName()+" Phone number: "+contact.getNumber());
	}
	
	public void displayAll() {
		for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getNumber();
            System.out.println("Key= " + key + ", Value=" + value);
	}
	}

	public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getName())) {
            System.out.println("Contact already exists. Please provide a different name.");
        } else {
            contacts.put(contact.getName(), contact);
            System.out.println("Contact added successfully.");
        }
    }

    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
        	this.displayContact(contacts.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }
    public void searchByNumber(String number) {
        for (Contact contact : contacts.values()) {
        	//System.out.println(contact.getNumber());
            if (contact.getNumber().equals(number)) {
                this.displayContact(contact);
            }else {
            	System.out.println("Contact not found.");
            }
        }
        
    }

    public void updateContactNumber(String name, String newNumber) {
        if (contacts.containsKey(name)) {
            contacts.get(name).setNumber(newNumber);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    
    public void updateContactName(String oldName, String newName) {
    	if (contacts.containsKey(oldName)) {
    		contacts.put(newName, contacts.get(oldName));
    		contacts.remove(oldName);
    		System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
	
}
