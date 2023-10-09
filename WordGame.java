
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Husain Rizvi
 * CMSY-167-N050
 * Final Project - Word Game (Hangman) - Hangman game that generates random words according to the difficulty level 
 * chosen by the user (1 - Basic (10 words) 2 - Medium (8 words) 3 - Difficult (6 words) and separates them into their
 * corresponding array lists. A word is generated and presented and the user is asked to guess a letter in the censored
 * word. The way to win the game is to correctly guess the random word presented within your guess constraints. 
 */

public class WordGame { // start of WordGame Hangman class
    
    private static Scanner input = new Scanner(System.in);  // creating an input scanner 
    
    private static ArrayList<String> basicList10 = new ArrayList<>();      // creating the array list for the ten letter words
    
    private static ArrayList<String> mediumList8 = new ArrayList<>();   // creating the array list for the eight letter words
    
    private static ArrayList<String> difficultList6 = new ArrayList<>();    // creating the array list for the six letter words
   
    private static ArrayList<String> lettersGuessed = new ArrayList<>();    // creating the array list for the guessed letters
    
    public static void main(String[] args) throws FileNotFoundException, IOException {    // start of main method
        
       String generatedWord = null; 
       
       int answer = 0;
       
       boolean continuePlaying = true; 
       
       do{  // start of do while loop to 
       
            listDivision(); // calling listDivision method to divide list into appropriate lists 
       
            StringBuilder blankWord = null; // creating blankWord StringBuilder
            blankWord = censoredWord(randomWordDifficulty());   // assigning the censoredWord generated to the blankWord StringBuilder 
       
            System.out.printf("%nThe word to guess is: %s", blankWord); // showing user censored out word
       
            userGuess();    // asking the user to enter guess
            
            System.out.println("\nYou have nine guesses left");
                
            System.out.println("\nWould you like to play again? (enter 1 for yes and 2 for no): "); // askign the user if they would like to play again 
            
            answer = input.nextInt();   // user input
            
            if(answer == 1){    // start of if statement 
                System.out.println("\nAlright, let's get another word ready for you.");
            }else if(answer == 2){  // quitting game and program 
                System.out.println("\nAlright, it was fun playing with you, have a good day!");
                continuePlaying = false;
                input.close();
            }else if(answer < 1 || answer > 2){ // incorrect input
                System.out.println("Error - please enter either 1 or 2");
            }     // end of if statement 
        
       } while(continuePlaying);    // end of do while loop 
       
        
    }   // end of main method
    
    /**
    * Upon loading, your program will load the list of words (hangmanWords.txt)
    * and divide it into three separate Lists based on word length: one List of six-letter words, 
    * one of eight-letter words, and one of ten-letter words.
    */
    
    private static void listDivision() throws FileNotFoundException{    // start of listDivision method for dividing provided file list
                
        try(Scanner output = new Scanner(Paths.get("hangmanWords.txt"))){   // start of try catch block 
           
            while(output.hasNextLine()){    // start of while loop for list division 
                                
              String entry = new String(output.nextLine()); // creating a String variable for Scanner object
              
              if(entry.length() == 10){  // start of if statement
                  
                  basicList10.add(entry);   // adding the 10 letter words to the according list
                    
              }else if(entry.length() == 8){   // adding words from list into appropriate lists
                  
                  mediumList8.add(entry);   // adding the eight letter words to the according list 
                  
              }else if(entry.length() == 6){ // adding words from list into appropriate lists
                  
                  difficultList6.add(entry);    // adding the six letter words to the according list 
                  
              } // end of if statement 
              
            }   // end of while loop 
            
            output.close(); // closing Scanner object
            
        }catch(IOException | NoSuchElementException | IllegalStateException e){ // catch block 
             System.err.println("There is no such file to be found");
        }   // end of try catch block 
        
    }   // end of listDivision method for dividing provided list
    
        /**
         * After loading the lists, your program should ask the user to select a difficulty level. 
         * There are three difficulty levels: basic, medium, and difficult. Each level determines
         * the word length and number of guesses provided for the user: 
         * 1 - Basic: 10 letter word, 10 guess attempts
         * 2 - Medium: 8 letter word, 7 guess attempts
         * 3 - Difficult: 6 letter word, 4 guess attempts
         */
    
    private static String randomWordDifficulty(){  // start of difficultyLevel method to obtain the difficulty level from user 
        
        int levelChoice;    // creating integer varaible for user input
        
        String generatedWord = null;    
        
        Random random = new Random();   // creating random to generate random word
            
        ArrayList<String> guessList = new ArrayList<>();  // creating an empty arraylist to generate random word
        
        do{ // start of do while loop for menu selection 
            
            System.out.println("Select one of the difficulty levels provided below:");
            
            System.out.println("\n1 - Basic: 10 letter word, 10 guess attempts "
                    + "\n2 - Medium: 8 letter word, 7 guess attempts "
                    + "\n3 - Difficult: 6 letter word, 4 guess attempts\n");
            
            levelChoice = input.nextInt();  // obtaining user input
            
            if(levelChoice > 3 || levelChoice < 1){ // start of if statement 
               System.out.println("Error - these entries are out of the given bounds. \nPlease input a number from 1-3.");
            }   // end of if statement 
            
        }while(levelChoice > 3 || levelChoice < 0); // end of do while loop 
        
        if(levelChoice == 1){   // start of if statement 
            
            System.out.println("\n1 - Is that all you've got? \nLet's begin... \n\nThe word to guess is an ten letter word and you have ten guesses available.");
            
            guessList = basicList10;    // assigning the 10 letter words to the empty arrayList
            
        }else if(levelChoice == 2){ // second level
            
            System.out.println("\n2 - Don't hurt yourself. \nLet's begin... \n\nThe word to guess is an eight letter word and you have seven guesses available.");
            
            guessList = mediumList8;    // assigning the 8 letter words to the empty arrayList
                
        }else if(levelChoice == 3){ // third level 
            
            System.out.println("\n3 - Are you sure you can handle it? \nLet's begin... \n\nThe word to guess is a six letter word and you have four guesses available.");
            
            guessList = difficultList6; // assigning the 6 letter words to the empty arrayList
            
        }    // end of if statement 
        
        return guessList.get(random.nextInt(guessList.size())); // generating and returning the random word 
        
    }   // end of difficultyLevel method to obtian the difficulty level from user 
    
    private static StringBuilder censoredWord(String censoredWord){ // start of censoredWord method to create the initial censoredWord with underscores
        
        StringBuilder blankWord = new StringBuilder("");    // creating a StringBuilder variable to create the censored word
        
        String randomWord;
        
        int count = 0;
        
        char character = 0;
                
        for(int i = 0; i < censoredWord.length(); i++){ // start of for loop creating censored word
            blankWord.append(" _ ");    // creating the censored word using '_'
        }   // end of for loop creating censored word
        
        return blankWord;   // returning generated censored word
        
    } // end of censoredWord method to create the initial censoredWord with underscores
    
    private static String userGuess(){  // start of userGuess method to produce the user's guess
        
        char characterGuess = 0;
                
        System.out.println("\nEnter your guess: "); 
        
        String userGuess = input.next();
        
        if(userGuess.isEmpty() || userGuess.length() > 1){  // start of if statement for user input errors 
            System.out.println("Error - guess a single character");
        } // end of if statement for user input errors
            
        return userGuess;
        
    }    // end of userGuess method to produce the user's guess
    
    /**
     * Counter for guesses
     * int count = 0;
     * for loop?
     */
    
}   // end of WordGame Hangman class
