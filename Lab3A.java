package com.mycompany.cmsy.n001_hrizvi.lab3a;

import static com.sun.tools.attach.VirtualMachine.list;
import java.lang.reflect.Array;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import static java.util.Collections.*;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Husain Rizvi
 * CMSY-167-N050
 * Lab3A - Collecting names for a monthly mailing list for the coordinator at HCC Honey Inc. 
 * Creating arrays and lists for the contacts name and doing processing and operations on them 
 * Such as sorting by zip code, searching by full name, searching by state, adding a contact, removing a contact, and printing out the contacts
 */

public class Lab3A { // start of Lab3A class
    
    public static Scanner input = new Scanner(System.in);     // creating Scanner object for user input
    
    public static final int ADD_ENTRY = 1;
    
    public static final int REMOVE_ENTRY = 2;
    
    public static final int SORT_ZIPCODE = 3;
    
    public static final int SEARCH_STATE = 4;
    
    public static final int SEARCH_NAME = 5;
    
    public static final int PRINT_RIDERS = 6;
    
    public static final int QUIT = 7;
    
    public static void main(String[] args) {    // start of main method
        
        Contact[] contactList = createArray();
        
        List<Contact> contacts = createList(contactList);
        
        boolean validChoice = false;
        
        int option = 0;
                
        do{ // start of do while loop for Menu and operations
            
            option = displayMenu();
            
            switch(option) {    // start of switch statement for menu operations 
                
                case ADD_ENTRY: // first option, adding a new entry
                    
                    contacts = addContact(contacts);
                    
                    break;  // end of adding a new entry case
                
                case REMOVE_ENTRY:  // second option, removing an entry 
                    
                    contacts = removeContact(contacts);
                    
                    break;  // end of removing an entry case 
                            
                case SORT_ZIPCODE:  // third option, sort by zip code
                    
                    sortByZip(contacts);
                    
                    break;  // end of sorting by zip code case
                
                case SEARCH_STATE:  // fourth option, search by state
                    
                    searchByState(contacts);
                                        
                    break;  // end of search by state case
                    
                case SEARCH_NAME:   // fifth option, search by full name 
                    
                    searchByFullName(contacts);
                    
                    break;  // end of search by full name case
                    
                case PRINT_RIDERS:  // sixth option, print riders
                    
                    printContacts(contacts);
                    
                    break;  // end of print riders case
                        
                case QUIT:  // seventh and last option, quit
                    
                    quitProgram();
                    
                    break;  // end of quit case
                
            }   // end of switch statement for menu operations
            
            
        }while(option != QUIT);   // end of do while loop for Menu and operations
    
    }   // end of main method
    
    public static int displayMenu(){    // start of displayMenu method 
        
        boolean validChoice = false;
        
        int choice = 0;
        
        do{ // start of do while loop for Menu and operations
            
            System.out.println("\nWhich of the following would you like to do?");
            
            System.out.println("1. Add a new entry");
            
            System.out.println("2. Remove an entry");
            
            System.out.println("3. Sort by zip code");
            
            System.out.println("4. Search by state");
                    
            System.out.println("5. Search by full name (exactly match the full name)");
            
            System.out.println("6. Print riders");
            
            System.out.println("7. Quit");
            
            choice = input.nextInt();
            
            if (choice < ADD_ENTRY || choice > QUIT){   // start of if statement for invalid entry 
               
                System.out.println("Error - Invalid entry. Please reenter a valid menu option (1-7)");
                   
                validChoice = false;
                
            }else{  
                validChoice = true;
            }   // end of if statement for invalid entry
            
        }while(!validChoice);   // end of do while loop for Menu and operations
        
        return choice;
        
    }   // end of displayMenu method
    
    private static List addContact(List contacts){   // start of addContact method
        
        Contact newContact = getContactInformation();
        
        contacts = addContactToList(newContact, contacts);
        
        return contacts;
    }   // end of addContact method
    
    private static Contact getContactInformation(){ // start of getContactInformation method
        
        System.out.println("What is the contact's full name?\n");
        
        String fullName = input.next();
        input.nextLine();
        
        System.out.println("What is the contact's address?\n");
        
        String address = input.next();
        input.nextLine();

        System.out.println("What city does the contact live in?\n");
        
        String city = input.next();
        input.nextLine();

        System.out.println("What state does the contact live in?\n");
        
        String state = input.next();
        input.nextLine();
       
        System.out.println("What is the contact's zip code?\n");
        
        String zipCode = input.next();
  	input.nextLine();
      
        System.out.println("What is the contact's phone number?\n");

        String phoneNumber = input.next();
        input.nextLine();

        Contact contact1 = new Contact(fullName, address, city, state, zipCode, phoneNumber);
                
        return contact1;
        
    }   // end of getContactInformation method
    
    private static List addContactToList(Contact contact1, List contacts){  // start of addContactToList method
        
        ArrayList<Contact> arrayList = new ArrayList(contacts);
        
        arrayList.add(contact1);
        
        return arrayList;
        
    }   // end of addContactToList method
        
    private static List<Contact> removeContact(List<Contact> contacts){    // start of removeContact method

        String fullName;
        
        System.out.println("\nPlease enter the contact's full name exactly to search (use '-' instead of spaces): ");
        
        fullName = input.next();
        
        ArrayList<Contact> arrayList = new ArrayList(contacts);
        
        Predicate<Contact> rFullName = e->(e.getFullName().equals(fullName));
   
        arrayList.remove(fullName);

        return arrayList;

    }   // end of removeContact method
    
    private static void sortByZip(List contacts){    // start of sortByZip method
        
        contacts.stream()
                .sorted(Comparator.comparing(Contact::getZipCode))
                .forEach(System.out::println);
    
    }   // end of sortByZip method
        
    private static List<Contact> searchByState(List<Contact> contacts){    // start of searchByState method
        
        String state;
        
        System.out.println("Please enter the contact's state to search: ");
        
        state = input.next();
        
        List<Contact> stateSearch = contacts.stream().filter(e->e.getState().toLowerCase().equals(state.toLowerCase())).collect(Collectors.toList());
                
        System.out.printf("%n%s", stateSearch);
        
        return stateSearch;

    }   // end of searchByState method
    
    private static String getLowerCaseSearchKey(String string){ // start of getLowerCaseSearchKey method
        
        System.out.printf("%nPlease enter whatever parameter was passed into the method (%s):", string);
        
        String userInput;
                
        userInput = input.next();
        
        return userInput;
    }   // end of getLowerCaseSearchKey method
    
    private static List<Contact> searchByFullName(List<Contact> contacts){ // start of searchByFullName method
        
        String fullName;
        
        System.out.println("\nPlease enter the contact's full name exactly to search (use '-' instead of spaces): ");
        
        fullName = input.next();
        
        List<Contact> fullNameSearch = contacts.stream().filter(e->e.getFullName().toLowerCase().equals(fullName.toLowerCase())).collect(Collectors.toList());
        
        System.out.printf("%n%s", fullNameSearch);
        
        return fullNameSearch;
    }   // end of searchByFullName method
        
    private static void printContacts(List contacts){    // start of printContacts method
        
       ArrayList<Contact> arrayList = new ArrayList(contacts);
       
       for(int i = 0; i < 1; i++){  // for statement for printing out contacts
            
            System.out.printf("%s%n", contacts);    // using the toString method from Contact class to print out contacts
            
        }   // for statement for printing out contacts 

    }   // end of printContacts method
    
    private static void quitProgram(){  // start of quitProgram method
        System.out.println("Quitting application. Thank you...goodbye.");
    }   // end of quitProgram method
    
    private static Contact[] createArray(){ // start of createArray array method
        
        Contact[] contacts = {  // creating the array of contacts
            
            new Contact("John-Harbaugh", "8397-Zip-Rd", "Baltimore", "MD", "21999", "123-456-7890"),
            new Contact("Mike-Tomlin", "147-LedStock-Ave", "Pittsburg", "PA", "07001", "890-123-4567"),
            new Contact("Kevin-Stepanski", "34-Main-St", "Cleveland", "OH", "07001", "456-789-0123"),
            new Contact("Zac-Taylor", "1222-Mover-Rd", "Cincinnati", "OH", "90001", "345-678-9012"),
            new Contact("Ron-Rivera", "190-Princeton-Ct", "Washington", "DC", "20001", "678-901-2345")
            
        };  // creating the array of contacts
        
        return contacts;
        
    }   // end of createArray array method
    
    public static List createList(Contact[] contactList){   // start of createList method for converting array into a list
        
        List<Contact> contactS = new ArrayList<>(Arrays.asList(contactList));
        
        return contactS;
            
    }   // end of createList method for converting array into a list
            
}   // end of Lab3A class
