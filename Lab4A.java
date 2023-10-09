package cmsy.pkg167.n001_hrizvi.lab4a;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Husain Rizvi
 * CMSY-167-N050
 * Lab4A - Creating a prototype for a program, creating an array of integer values 
 * and allowing a user to determine whether a new number request is already in the list by implementing an
 * iterative search method and a recursive sort method
 */

public class Lab4A { // start of Lab4A class
    
    public static Scanner input = new Scanner(System.in);     // creating Scanner object for user input

    public static void main(String[] args) { // start of main method
      
        // Create an array of the integer values that have already been taken
        int[] userNumbers = {1, 24, 6, 8, 32, 4, 80, 99, 43, 34, 77, 64, 85};
                
        System.out.printf("Unsorted array: %s%n%n", Arrays.toString(userNumbers));
        
        mergeSort(userNumbers); // sort array
        
        System.out.printf("Sorted array: %s%n", Arrays.toString(userNumbers));
        
        // get input from user
        System.out.print("Please enter an integer value (1-100) (-1 to quit): ");
        
        int searchInt = input.nextInt();
        
        // repeatedly input an integer; -1 terminates the program
        while(searchInt != -1){ // start of while loop 
            
            // preform search
            int location = binarySearch(userNumbers, searchInt);
            
            if(location == -1){ // not found
                System.out.println("Thank you for your donation, good luck!");
            }    else{  // found
                System.out.println("This number is taken...BEE GONE!");
            }   // end of if statement
            
            // get input from user
            System.out.print("Please enter an integer value (1-100) (-1 to quit): ");
        
            searchInt = input.nextInt();
            
        }   // end of while loop 
       
    }   // end of main method
    
    /**
    * START OF RECURSIVE SORTING ARRAY METHODS (mergeSort, sortArray, merge, and subarrayString) obtained from Java textbook
    * TITLE: Java How to Program, Early Objects 11th Edition
    * AUTHOR: Paul Deitel; Harvey Deitel
    * PAGE NUMBER: 813 (809-813)
    */
    
    // calls recursive sortArray method to begin merge sorting
    public static void mergeSort(int[] userNumbers) {   // start of mergeSort method
        
        sortArray(userNumbers, 0, userNumbers.length - 1); // sort entire array
        
    }   // end of mergeSort method
    
    /**
    * START OF RECURSIVE SORT METHOD sortArray obtained from Java textbook
    * TITLE: Java How to Program, Early Objects 11th Edition
    * AUTHOR: Paul Deitel; Harvey Deitel
    * PAGE NUMBER: 813 (809-813)
    */

    // splits array, sorts subarrays and merges subarrays into sorted array
    private static void sortArray(int[] userNumbers, int low, int high) {   // start of sortArray recursive method
        
        // test base case; size of array equals 1
        if ((high - low) >= 1) { // if not base case
            
            int middle1 = (low + high) / 2; // calculate middle of array
            int middle2 = middle1 + 1; // calculate next element over

            // output split step
            System.out.printf("split:  %s%n",
               subarrayString(userNumbers, low, high));
            
            System.out.printf("  %s%n",
               subarrayString(userNumbers, low, middle1));
            
            System.out.printf("  %s%n%n",
               subarrayString(userNumbers, middle2, high));

            // split array in half; sort each half (recursive calls)
            sortArray(userNumbers, low, middle1); // first half of array
            
            sortArray(userNumbers, middle2, high); // second half of array

            // merge two sorted arrays after split calls return
            merge (userNumbers, low, middle1, middle2, high);
            
        } // end of if statement
        
    }   // end of sortArray recursive method

    // merge two sorted subarrays into one sorted subarray
    private static void merge(int[] userNumbers, int left, int middle1,
        int middle2, int right) {   // start of merge method

        int leftIndex = left; // index into left subarray
        
        int rightIndex = middle2; // index into right subarray
        
        int combinedIndex = left; // index into temporary working array
        
        int[] combined = new int[userNumbers.length]; // working array

        // output two subarrays before merging
        System.out.printf("merge:  %s%n",
            subarrayString(userNumbers, left, middle1));
        
        System.out.printf("  %s%n",
            subarrayString(userNumbers, middle2, right));
 
         // merge arrays until reaching end of either
         while (leftIndex <= middle1 && rightIndex <= right) { // start of while loop
             
            // place smaller of two current elements into result
            // and move to next space in arrays
            if (userNumbers[leftIndex] <= userNumbers[rightIndex]) {  // start of if statement
                
                combined[combinedIndex++] = userNumbers[leftIndex++];
                
            }
            else {
                
                combined[combinedIndex++] = userNumbers[rightIndex++];
                
            }   // end of if statement
            
         }  // end of while loop 
 
         // if left array is empty
         if (leftIndex == middle2) {    // start of if statement
             
            // copy in rest of right array
            while (rightIndex <= right) {   // start of while loop 
                
                combined[combinedIndex++] = userNumbers[rightIndex++];
                
            }   // end of while loop 
         }
         else { // right array is empty
             
            // copy in rest of left array
            while (leftIndex <= middle1) { // start of while loop 
                
               combined[combinedIndex++] = userNumbers[leftIndex++];
               
            }   // end of while loop 
            
         }  // end of if statement
 
          // copy values back into original array
         for (int i = left; i <= right; i++) {  // start of for loop 
             
             userNumbers[i] = combined[i];
             
         }  // end of for loop 
 
         // output merged array
         System.out.printf("  %s%n%n",
            subarrayString(userNumbers, left, right));
         
    }   // end of merge method
 
       // method to output certain values in array
    private static String subarrayString(int[] userNumbers, int low, int high) {    // start of subarrayString method
        
         StringBuilder temporary = new StringBuilder();
 
          // output spaces for alignment
          for (int i = 0; i < low; i++) {   // start of for loop 
             temporary.append("  ");
          } // end of for loop 
 
          // output elements left in array
         for (int i = low; i <= high; i++) {    // start of for loop 
             temporary.append(" " + userNumbers[i]);
          } // end of for loop 

         return temporary.toString();
         
    }   // end of subarrayString method
    
    /**
    * START OF ITERATIVE BINARY SEARCH METHOD binarySearch obtained from Java textbook
    * TITLE: Java How to Program, Early Objects 11th Edition
    * AUTHOR: Paul Deitel; Harvey Deitel
    * PAGE NUMBER: 801 (798-801)
    */
    
    // perform a binary search on the data
    public static int binarySearch(int[] userNumbers, int key) { // start of binarySearch iterative search method
         
        int low = 0; // low end of the search area
         
        int high = userNumbers.length - 1; // high end of the search area
         
        int middle = (low + high + 1) / 2; // middle element
         
        int location = -1; // return value; -1 if not found

        do { // loop to search for element
            
            // print remaining elements of array
            System.out.print(remainingElements(userNumbers, low, high));

            // output spaces for alignment
            for (int i = 0; i < middle; i++) {  // start of for loop
               System.out.print("  ");
            }   // end of for loop
            
            System.out.println(" * "); // indicate current middle

            // if the element is found at the middle
            if (key == userNumbers[middle]) {   // start of if statement
               location = middle; // location is the current middle
            }
            else if (key < userNumbers[middle]) { // middle element is too high
               high = middle - 1; // eliminate the higher half
            }
            else { // middle element is too low
               low = middle + 1; // eliminate the lower half
            }   // end of if statement

            middle = (low + high + 1) / 2; // recalculate the middle
            
         } while ((low <= high) && (location == -1));   // end of do while loop 

         return location; // return location of search key
         
    }   // end of binarySearch iterative search method

    // method to output certain values in array
    private static String remainingElements(int[] userNumbers, int low, int high) { // start of remainingElements method
         
        StringBuilder temporary = new StringBuilder();

        // append spaces for alignment
        for(int i = 0; i < low; i++) {  // start of for loop
            temporary.append("  ");
        }   // end of for loop 

        // append elements left in array
        for (int i = low; i <= high; i++) { // start of for loop 
            temporary.append(userNumbers[i] + " ");
        }   // end of for loop 

         return String.format("%s%n", temporary);
         
    }  // end of remainingElements method
    
}   // end of Lab4A class
