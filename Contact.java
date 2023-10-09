/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cmsy.n001_hrizvi.lab3a;

import java.io.PrintStream;

/**
 *
 * @author Husain Rizvi
 * CMSY-167-N050
 * Lab3A Project - Contact class with the constructor, toString, and get and set methods for the instance variables
 */

public class Contact {  // start of Contact class
    
    // Creating instance variables
    String fullName;
    String address;
    String city;
    String state;
    String zipCode;
    String phoneNumber;
    
    public Contact(String fullName, String address, String city, String state, String zipCode, String phoneNumber){   // start of Contact contstrucot method
        
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        
    }   // end of Contact constructor method

    public String getAddress() {    // start of getAddress method
        return address;
    }   // end of getAddress method

    public void setAddress(String address) {    // start of setAddress method
        this.address = address;
    }   // end of setAddress method

    public String getCity() {   // start of getCity method
        return city;
    }   // end of getCity method

    public void setCity(String city) {  // start of setCity method
        this.city = city;
    }   // end of setCity method
    
    public String getFullName() {   // start of getFullName method
        return fullName;
    }   // end of getFullName method

    public void setFullName(String fullName) {  // start of setFullName method
        this.fullName = fullName;
    }   // end of setFullName method

    public String getPhoneNumber() {   // start of getPhoneNumber method
        return phoneNumber;
    }   // end of getPhoneNumber method

    public void setPhoneNumber(String phoneNumber) {   // start of setPhoneNumber method
        this.phoneNumber = phoneNumber;
    }   // end of setPhoneNumber method
    
    public String getState() {  // start of getState method
        return state;
    }   // end of getState method
    
    public void setState(String state) {    // start of setState method
        this.state = state;
    }   // end of setState method

    public String getZipCode() {   // start of getZipCode method
        return zipCode;
    }   // end of getZipCode method

    public void setZipCode(String zipCode) {   // start of setZipCode method
        this.zipCode = zipCode;
    }   // end of setZipCode method

    @Override
    public String toString() {  // start of toString method
          return String.format("%-25s%-25s%-20s%-10s%-10s%-15s%n", getFullName(), getAddress(), getCity(), getState(), getZipCode(), getPhoneNumber());
    }   // end of toString method
    
        
}   // end of Contact class
