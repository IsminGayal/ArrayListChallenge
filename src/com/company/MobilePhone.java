package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumer;
    private  ArrayList<Contact> contactList;

    public MobilePhone(String myNumer) {
        this.myNumer = myNumer;
        this.contactList = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        contactList.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName()+", was not found");
            return false;
        }
        else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successfull");
            return false;
        }
        this.contactList.set(foundPosition, newContact);
        System.out.println(oldContact.getName()+", was replaced with "+newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getName()+", was not found");
            return false;
        }
        this.contactList.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i=0; i<this.contactList.size(); i++) {
            Contact contact = this.contactList.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return this.contactList.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (int i=0; i<this.contactList.size(); i++) {
            System.out.println((i+1) + "." +
                    this.contactList.get(i).getName() + " -> " +
                    this.contactList.get(i).getPhoneNumber());
        }
    }
}

