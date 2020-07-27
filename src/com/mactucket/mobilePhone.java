package com.mactucket;

import java.util.ArrayList;

public class mobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;


    public mobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            System.out.println("Contact already exists");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public void printContacts(){
        System.out.println("You have" + myContacts.size() + "contacts in your Contact list");
        for(int i = 0; i< myContacts.size(); ++i){
            System.out.println((i+1) + ". " + myContacts.get(i));
        }
    }

    public boolean removeContact (Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition <0){
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed");
        return true;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i<this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        } return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition <0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }
        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + " was replace with " + newContact.getName());
        return true;

    }

    public String queryContact(Contact contact){
        if(findContact(contact) >=0){
            return contact.getName();
        }
        return null;

    }



}
