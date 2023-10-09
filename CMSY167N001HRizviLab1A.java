package cmsy.pkg167.n001.hrizvi.lab1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Husain Rizvi
 * CMSY-167-N050
 * Processing of contents of content list for HCC Honey Inc.
 */

public class CMSY167N001HRizviLab1A {   // start of Lab1A class

    public static void main(String[] args) {    // start of main method
        
      // Start try and catch block to create Scanner object for reading contactList-1.txt file
      try(Scanner input = new Scanner(Paths.get("contactList-1.txt"))) {
         // Second try and catch block to create Formatter object for outputting emails.txt file
          try(Formatter output = new Formatter("emails.txt")) { 
             
              while (input.hasNextLine()) { // while loop through the input file until there is no more lines
               
              String string = new String(input.nextLine()); // creating a String variable for Scanner object
            
              String stringA[]=string.split(",");   // Splitting the information from contactList-1.txt file
     
               if(stringA[2] == null){  // start of if statement for missing email address error message
                   
                   System.err.printf("Missing email address: %s, %s, %s", stringA[0], stringA[1], stringA[3]);
                   
               }    // end of if statement for missing email address error message 
               
               if(!stringA[2].contains("@")){   // start of if statement for missing @ symbol
                   
                   System.err.printf("Address invalid: %s. Missing @ symbol.", stringA[2]);
                   
               }    // end of if statement for missing @ symbol
               
               String firstName = stringA[0].trim();    // trimming firstName for errors
               
               String lastName = stringA[1].trim(); // trimming lastName for errors 
                   
               boolean subscriber = false;
               
                if(stringA[3] == "Y" || stringA[3] == "y"){ // start of if statement to validate the subscribers 
                    subscriber = true;
                }else{
                    subscriber = false;
                }   // end of if statement to validate the subscribers
                
                // creating StringBuilder to generate email
                StringBuilder email = new StringBuilder();
                
                // Generating email and outputting to emails.txt file
                
                output.format("====================\n");
            
                output.format("\nTo: %s\n", stringA[2]);
                
                output.format("From: beehoney@howardcc.edu \n");
                
                output.format("Subject: Sweet Honey Sale for Valentines Day!\n\n");
                
                output.format("Hi %s %s! \n\n", stringA[0], stringA[1]);
                
                output.format("Bee sweet to your valentine (or yourself) this year!\n\nBuzz into the HCC bookstore and buy a 16 oz bottle of Wildflower\nHoney for only $7.95.  Act soon... supplies are limited.\n\n\nHCC Honey Inc\n");
                
                output.format("====================\n");
               
             }  // end of while loop
              
          }  // end of second try block for Formatter object
         catch (SecurityException | FileNotFoundException | 
            FormatterClosedException e) {
             
            System.err.println("There is no such file to be found");
            
            System.exit(1); // terminate the program
            
        }   // end of second catch block for Formatter object
          
      } // end of first try block for Scanner object
      catch (IOException | NoSuchElementException | 
         IllegalStateException e) {
          
         System.err.println("There is no such file to be found");
         
      } // end of first catch block for Scanner object
        
    }   // end of main method    
    
}   // end of Lab1A class

