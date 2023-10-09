
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * FinalLab - One Stop Table Shop by Master Builder Husain Rizvi
 * Driver Class
 */

import java.util.Scanner;  // program uses class Scanner

public class FinalLab {// start of FinalLab driver class
	
	// static scanner object used by all methods
	
	public static Scanner input = new Scanner(System.in);
				
			/*
			 * Constants throughout the program:
			 */
				
	public static final int RECTANGULAR_TABLE = 1;	// Rectangle Table constant
				
	public static final int CIRCULAR_TABLE = 2;	// Circular Table constant
				
	public static final int TRAPEZOID_TABLE = 3;	// Trapezoid Table constant
				
	public static final int END_PROGRAM = 4;	// End Program constant
			
	public static final int LAMINATE_MATERIAL = 1;	// Laminate Material constant
				
	public static final int OAK_MATERIAL = 2;	// Oak material constant
				
	public static final double LAMINATE_COST = 0.125;	// Laminate Cost constant
				
	public static final double OAK_COST = 0.25;	// Oak cost constant
			
	public static final int FIRST_DISCOUNT = 1000;	// first discount constant
				
	public static final int SECOND_DISCOUNT = 3000;	// second discount constant
				
	public static final double DISCOUNT_AMOUNT = 0.05;	// first discount amount (5%) constant
				
	public static final double DISCOUNT_AMOUNT2 = 0.1;	// second discount amount (10%) constant
				
	public static final int ONE_TABLE = 1;	// one table constant
			
	public static final int TABLES_FINAL_AMOUNT = 10;	// final amount of tables
		
	public static final int PRIVATE_CUSTOMER = 1;	// first customer option
		
	public static final int COMMERCIAL_CUSTOMER = 2;	// 2nd customer option
		
	public static final int GUEST_CUSTOMER = 3;	// 3rd customer option
		
	public static final int TOTAL_MONTHS = 12;// total months in a year
		
	public static final int MIN_YEAR = 2010;	// minimum year for expiration date
		
	public static final int MAX_YEAR = 2030;	// max year for expiration date
	
	public static final double CHAIR = 495;	// constant area of a chair

	public static void main(String[] args) {// start of main method
	
		// create an array of objects of type Table (class)
		Table[] aTable = new Table[TABLES_FINAL_AMOUNT];
		
		Chair[] aChair = new Chair[TABLES_FINAL_AMOUNT];
				
		Customer guestCust = new Customer();
				
		Commercial commCust = new Commercial();
			
		Individual privCust = new Individual();
					
		int option, choice, expMon, expYear, maxNumChairs, numChairs, tableCount = 0;
				
		int option1 = 0;
		
		int chairCount = 0;
					
		String shape, material, name, email, phoneNum, accNum, cardType, cardNum, accType = null;
				
		double area = 0, length = 0, width = 0, shortBase = 0, longBase = 0, diameter = 0, height = 0;
					
		welcome();	// calling welcome method 
				
		/**
		 * Entering in customer information:
		 */
				
		System.out.println("\nEnter your customer information: ");
				
		System.out.println("Please enter your name: ");
				
		name = input.nextLine();
				
		System.out.println("Please enter your email address: ");
				
		email = input.nextLine();
				
		System.out.println("Please enter your phone number: ");
				
		phoneNum = input.nextLine();
				
		option1 = customerMenu();
				
		switch(option1) {	// start of switch statement for customer option
				
		case PRIVATE_CUSTOMER: 	// First option
					
			boolean validEntry = false;
					
			System.out.println("Please enter your account number: ");
					
			accNum = input.next();
					
			input.nextLine();
					
			System.out.println("\nPlease enter in your credit card type: ");
					
			cardType = input.next();
					
			input.nextLine();
					
			System.out.println("Please enter in your credit card number: ");
					
			cardNum = input.next();
					
			input.nextLine();
					
			do {	// do while loop for valid entry
						
				System.out.println("Please enter in your credit card expiration month: ");
						
				expMon = input.nextInt();
						
				if(expMon < 0 || expMon > TOTAL_MONTHS) {	// if loop for valid entry 
							
					System.out.println("Error - the month entered must be a valid month (1-12). Please reenter!!");
							
					validEntry = false;
							
				}	else {	// if loop for valid entry
					validEntry = true;	
				}	// if loop for valid entry 
					
			} while(!validEntry);	// end of do while loop for valid entry 
					
			do {	// do while loop for valid entry 
						
				System.out.println("Please enter in your credit card expiration year: ");
						
				expYear = input.nextInt();
						
				if(expYear < MIN_YEAR || expYear > MAX_YEAR) {	// if loop for valid entry 
							
					System.out.println("Error - the year must be between 2010 and 2030. Please reenter!!");
							
					validEntry = false;
							
				}	else {	// if loop for valid entry 
					validEntry = true;
				}	// if loop for valid entry 
					
			} while(!validEntry);	// do while loop for valid entry 
								
			privCust = new Individual(name, email, phoneNum, accNum, cardType, cardNum, expMon, expYear);
					
			break;
					
		case COMMERCIAL_CUSTOMER:	// 2nd Option
					
			System.out.println("Please enter your account number: ");
					
			accNum = input.next();
					
			System.out.println("Please enter in your account type: ");
					
			accType = input.next();
					
			commCust = new Commercial(name, email, phoneNum, accNum, accType);
					
			break;
				
		case GUEST_CUSTOMER:	// 3rd Option
					
			guestCust = new Customer(name, email, phoneNum);
					
			break;
				
		}	// end of switch statement for customer option
					
		do {	// start of do while loop 
						
			option = displayMenu();// calling displayMenu method and assigning it to an int variable 
						
			aTable[tableCount] = new Table();
			
			aChair[tableCount] = new Chair();
						
			switch(option) {// start of switch statement 
						
			case RECTANGULAR_TABLE:// first choice, rectangle
						
				boolean validEntry = false;
							
				do{	// start of do while loop to get user to input length 
								
					System.out.println("Enter the length of the table (in inches): ");
								
					length = input.nextInt();
								
					if(length < 0) {	// error trap loop
								
						System.out.println("Error - the length must be greater than zero. Please reenter!!");
									
						validEntry = false;
								
					} else {	// error trap loop
						validEntry = true;
					}	// end of error trap loop
				} while(!validEntry);	// end of do while loop for length entry
							
				do {	// start of do while loop to get user to input width 
							
					System.out.println("Enter the width of the table (in inches): ");
							
					width = input.nextInt();
								
					if(width < 0) {	// error trap loop
								
						System.out.println("Error - the width must be greater than zero. Please reenter!!");
									
						validEntry = false;
								
					}else {	// error trap loop
								
						validEntry = true;
					}	// end of error trap loop
						
				} while(!validEntry);	// end of do while loop for width entry
							
				// storing appropriate values in their corresponding arry
								
				area = calculateArea(length, width);
							
				aTable[tableCount].setArea(area);
					
				maxNumChairs = aTable[tableCount].calculateNumChairs();
					
				System.out.printf("%nThe table will accommodate %d chairs%n", maxNumChairs);
						
				do {	// start of do while loop for number of chairs
							
					System.out.printf("%nHow many chairs would you like to purchase with this table?");
						
					numChairs = input.nextInt();
						
					if(numChairs < 0) {	// start of error trap loop
							
						System.out.printf("Error - the number of chairs must be between 0 and %d. Please reenter!!", maxNumChairs);
							
						validEntry = false;
					} else if(numChairs > maxNumChairs) {	// error trap 
							
						System.out.printf("Error - the number of chairs must be between 0 and %d. Please reenter!!", maxNumChairs);
							
						validEntry = false;
					}else {	// error trap 
						validEntry = true;
					}	// end of error trap loop
				
						
				}while(!validEntry);	// end of do while loop
				
				aChair[tableCount].setNumChairs(numChairs);
				
				aChair[tableCount].setArea(numChairs * CHAIR);
				
				chairCount += numChairs;
				
				shape = "Rectangular";
							
				aTable[tableCount].setShape(shape);
									
				break;	// breaking out of loop 
						
			case CIRCULAR_TABLE: // second choice circular
							
				validEntry = false;
															
				do {	// start of do while loop for diameter entry
							
					System.out.println("Enter the diameter of the table (in inches): ");
							
					diameter = input.nextInt();
								
					if(diameter < 0) {	// error trap loop
								
						System.out.println("Error - the diameter must be greater than zero. Please reenter!!");
								
						validEntry = false;
								
					}else {	// error trap loop
								
						validEntry = true;
								
					}	// end of error trap loop
							
				}while(!validEntry);	// end of do while loop 
							
				// storing appropriate values in their corresponding arrays
							
				area = calculateArea(diameter);
							
				aTable[tableCount].setArea(area);
					
				maxNumChairs = aTable[tableCount].calculateNumChairs();
					
				System.out.printf("%nThe table will accommodate %d chairs%n", maxNumChairs);
						
				do {		// start of do while loop for number of chairs 
							
					System.out.printf("How many chairs would you like to purchase with this table?");
						
					numChairs = input.nextInt();
						
					if(numChairs < 0) {	// start of error trap loop
							
						System.out.printf("Error - the number of chairs must be between 0 and %d. Please reenter!!", maxNumChairs);
							
						validEntry = false;
					} else if(numChairs > maxNumChairs) {	// error trap loop
							
						System.out.printf("Error - the number of chairs must be between 0 and %d. Please reenter!!", maxNumChairs);
							
						validEntry = false;
					}else {	// error trap loop
						validEntry = true;
					}	// error trap loop
						
				}while(!validEntry);	// end of error trap loop 
				
				aChair[tableCount].setNumChairs(numChairs);
				
				aChair[tableCount].setArea(numChairs * CHAIR);
				
				chairCount += numChairs;
							
				shape = "Circular";
							
				aTable[tableCount].setShape(shape);
									
				break;// end of circular table case 
							
			case TRAPEZOID_TABLE:	// third choice trapezoid
							
				validEntry = false;
									
				do {	// start of do while loop for shortBase entry
								
					System.out.println("Enter the short base of the table (in inches): ");
								
					shortBase = input.nextInt();
								
					if(shortBase < 0) {	// error trap loop
								
						System.out.println("Error - the short base must be greater than zero. Please reenter!!");
									
						validEntry = false;
								
					}else {	// error trap loop
								
						validEntry = true;
							
					}	// end of error trap loop
							
				}while(!validEntry);	// end of do while loop for short base entry
							
				do {	// start of do while loop for long base entry
								
					System.out.println("Enter the long base of the table (in inches): ");
							
					longBase = input.nextInt();
								
					if(longBase < 0) {	// error trap loop
								
						System.out.println("Error - the long base must be greater than zero. Please reenter!!");
									
						validEntry = false;
								
					}else {	// error trap loop
							
						validEntry = true;
								
					}	// end of error trap loop
							
				}while(!validEntry);	// end of do while loop for long base entry
							
				do {	// start of do while loop for height entry
								
					System.out.println("Enter the height of the table (in inches): ");
							
					height = input.nextInt();
								
					if(height < 0) {	// error trap loop
								
						System.out.println("Error - the height must be greater than zero. Please reenter!!");
									
						validEntry = false;
								
					}else {	// error trap loop
								
						validEntry = true;
								
					}	// end of error trap loop
							
				}while(!validEntry);	// end of do while loop for height entry 
							
				// storing appropriate values in their corresponding arrays

				area = calculateArea(shortBase, longBase, height);
							
				aTable[tableCount].setArea(area);
					
				maxNumChairs = aTable[tableCount].calculateNumChairs();
					
				System.out.printf("%nThe table will accommodate %d chairs%n", maxNumChairs);
					
				do {		// start of do while loop for number of chairs 
						
					System.out.printf("How many chairs would you like to purchase with this table?");
					
					numChairs = input.nextInt();
					
					if(numChairs < 0) {	// start of error trap loop 
						
						System.out.printf("Error - the number of chairs must be between 0 and %d. Please reenter!!", maxNumChairs);
						
						validEntry = false;
					} else if(numChairs > maxNumChairs) {	// error trap loop
							
						System.out.printf("Error - the number of chairs must be between 0 and %d. Please reenter!!", maxNumChairs);
						
						validEntry = false;	
					}else {	// error trap loop 
						validEntry = true;
					}	// end of error trap loop 
					
				}while(!validEntry);
				
				aChair[tableCount].setNumChairs(numChairs);
				
				aChair[tableCount].setArea(numChairs * CHAIR);

				chairCount += numChairs;
							
				shape = "Trapezoid";
							
				aTable[tableCount].setShape(shape);	
							
				break;	// end of trapezoidal table case 
							
			case END_PROGRAM: // last choice end program
							
				// displaying output 
						
				System.out.println("\t\tOutput Report");
						
				System.out.println("\t\t-------------");
						
				if(option1 == PRIVATE_CUSTOMER) { // if loop for first customer option
					System.out.println(privCust);
				}	// if loop for first customer option
						
				if(option1 == COMMERCIAL_CUSTOMER) {// if loop for second customer option
					System.out.println(commCust);
				}// if loop for second customer option
						
				if(option1 == GUEST_CUSTOMER) { // if loop for 3rd customer option
					System.out.println(guestCust);
				}	// if loop for 3rd customer option
							
				display(aTable, tableCount, aChair);
						
				display2(aTable, tableCount, aChair, chairCount);	// displaying final estimate
							
				break;
							
			}	// end of switch statement
						
						
			if(option != END_PROGRAM || tableCount > TABLES_FINAL_AMOUNT) {	// start of if loop for sub menu
							
				choice = display2Menu();	// calling 2nd menu and storing value in int variable
							
				if(choice == LAMINATE_MATERIAL) {	// start of if loop for first material choice
								
					// storing appropriate values in their corresponding arrays
								
					material = "Laminate";
							
					aTable[tableCount].setMaterial(material);
					
					aChair[tableCount].setMaterial(material);
							
				}else {	// if loop for second material choice
								
					// storing appropriate values in their corresponding arrays

					material = "Oak";
								
					aTable[tableCount].setMaterial(material);
					
					aChair[tableCount].setMaterial(material);
							
				}	// end of if loop for menu choices
							
				tableCount++;
						
			}	// end of if loop for sub menu
						
		}while(option != END_PROGRAM || tableCount > TABLES_FINAL_AMOUNT);	// end of do while loop 
					
		input.close();	// closing Scanner object
		
	}// end of main method
	
	public static void welcome() {	// start of welcome method 
		
		System.out.println("Welcome to Tables are Us - Your One Stop Table Shop");
			
		System.out.println("Husain Rizvi - Master Table Builder\n");
		
	}	// end of welcome method 
		
	public static int displayMenu() {	// start of displayMenu method 
		
		// DISPLAYING STARTING MENU FOR TABLE SHAPE
			
		int choice = 0;
			
		boolean validChoice = false;
			
		do
		{	// start of do while loop for menu 
		
			System.out.println("\nWhat shape of table do you wish to build?");
				
			System.out.println("\t1. Rectangular");
				
			System.out.println("\t2. Circular");
				
			System.out.println("\t3. Trapezoid");
				
			System.out.println("\t4. End Program");
				
			System.out.println("Enter Menu Entry: ");
				
			choice = input.nextInt();
				
			if(choice < RECTANGULAR_TABLE || choice > END_PROGRAM) {	// start of error trap loop
				
				System.out.println("Error - Invalid entry. Please reenter a valid menu option");
					
				validChoice = false;
				
			}else {	// error trap loop
				
				validChoice = true;
				
			}	// error trap loop
				
		} while(!validChoice);	// end of do while loop for menu
				
		return choice;
			
	}	// end of displayMenu method
		
	public static double calculateArea(double a, double b) {	// start of overloaded calculateArea method 
		// CALCULATING AREA FOR RECTANGULAR TABLE
		return a * b;
	}	// end of overloaded calculateArea method
			
	public static double calculateArea(double a) {	// start of overloaded calculateArea method
		// CALCULATING AREA FOR CIRCULAR TABLE
		double b = a/2;
			
		return Math.PI * (b*b);
	}	// end of overloaded calculateArea method
			
	public static double calculateArea(double a, double b, double c) {	// start of overloaded calculateArea method
		// CALCULATING AREA FOR TRAPEZOID TABLE
		return ((a+b)/2) * c;
	}	// end of overloaded calculateArea method
		
	public static int display2Menu() { // start of second display menu method for material choice
			
		// DIPLAYING MENU FOR MATERIAL CHOICE 
			
		int choice = 0;
			
		boolean validChoice = false;
			
		do {	// start of do while loop displaying menu and asking for input
				
			System.out.println("\nWhat type of material do you want to use?");
				
			System.out.println("\t1. Laminate ($0.125 per square inch)");
				
			System.out.println("\t2. Oak ($0.25 per square inch)");
				
			System.out.println("Enter Menu Entry: ");
				
			choice = input.nextInt();
				
			if(choice < LAMINATE_MATERIAL || choice> OAK_MATERIAL) {	// start of error trap loop
					
				System.out.println("Error - Invalid entry. Please reenter a valid value");
					 
				validChoice = false;
			}	// end of if statement
				
		}while(choice < LAMINATE_MATERIAL || choice > OAK_MATERIAL);	// end of do while loop 
			
		return choice;
	}	// end of display2Menu method 
		
	public static void display(Table[] aTable, int tableCount, Chair[] aChair) {	// start of display output method
			
		for(int i = 0; i < tableCount; i++) {	// start of for loop to print out the output report
			
			System.out.print("\nTable " + (i+1) + ": ");
				
			System.out.printf("%n        The area of the %s table is %.2f square inches", aTable[i].getShape(), aTable[i].getArea());
				
			System.out.printf("%n        The table will be made of %s", aTable[i].getMaterial());
			
			System.out.printf("%n        The cost of this table is $%.2f", aTable[i].calcCost());
				
			System.out.printf("%n        The table will accommodate %d chairs",	aTable[i].calculateNumChairs());
				
			System.out.printf("%n        %d chairs were requested at a cost of $%.2f%n%n", aChair[i].getNumChairs(), aChair[i].calcCost());
			
		}	// end of for loop 
			
	}	// end of display output method
		
	public static double discount(double totalPurchase) {	// start of calculating discount method
			
		double disc;
			
		if(totalPurchase < FIRST_DISCOUNT) {	// start of if statement for first discount
			
			disc = 0;
			
		}else if(totalPurchase < SECOND_DISCOUNT && totalPurchase >= FIRST_DISCOUNT) {	// if statement for calculating discount
		
			disc = DISCOUNT_AMOUNT * totalPurchase;
			
		}else {	// if statement for calculating discount
			
			disc = DISCOUNT_AMOUNT2 * totalPurchase;
			
		}	// end of if statement for calculating discount
			
		return disc;
	}	// end of calculating discount method
	
	public static void display2(Table[] aTable, int tableCount, Chair[] aChair, int chairCount) {	// start of final estimate display method
			
		double disc, totCost;

		totCost = calculateTotalCost(aTable, tableCount, aChair);
			
		if(tableCount == ONE_TABLE) {	// start of if statement for if there is one table
			
			System.out.printf("The total cost of the %d table and the %d chairs you estimated is $%.2f%n", tableCount, chairCount, totCost);
			
		}else if(tableCount > ONE_TABLE) {	// if statement for if there is more than one table
			
			System.out.printf("The total cost of the %d tables and the %d chairs you estimated is $%.2f%n", tableCount, chairCount, totCost);
			
		}else {	// if statement if there are no tables
		
			System.out.println("You did not estimate any tables today!");
			
		}	// end of if statement
			
		disc = discount(totCost);
			
		if(disc != 0) {	// if statement for discount output
			
			System.out.printf("Your discount is $%.2f%n", disc);
				
			System.out.printf("Your final total is $%.2f%n", totCost - disc);
			
		}	// end of if statement for discount output

		System.out.println("\nThank you for using the table cost estimation program!" + 
		"\nGoodbye!!");
	}	// end of final estimate display method
		
	public static double calculateTotalCost(Table[] aTable, int tableCount, Chair[] aChair) {	// start of calculateTotalCost method that has a parameter of cost of each table array 
			
		double finalCost = 0, cost = 0;
			
		for(int i = 0; i < tableCount; i++) {	// start of for loop for calculating total table cost
				
			cost = aTable[i].calcCost() + aChair[i].calcCost();
				
			finalCost += cost;
								
		}	// end of for loop for calculating total table cost
			
		return finalCost;	
		
	}	// end of calculateTotalCost method 
	
	public static int customerMenu() {	// start of customerMenu method 
					
		int choice = 0;
			
		boolean validChoice = false;
			
		do
		{	// start of do while loop for menu 
		
			System.out.println("\nWhat type of customer are you?");
				
			System.out.println("\t1. Private Customer");
				
			System.out.println("\t2. Commercial Customer");
				
			System.out.println("\t3. Guest");
				
			System.out.println("Enter customer type: ");
				
			choice = input.nextInt();
				
			if(choice < RECTANGULAR_TABLE || choice > TRAPEZOID_TABLE) {	// start of error trap loop
				
				System.out.println("Error - Invalid entry. Please reenter a valid menu option");
					
				validChoice = false;
				
			}else {	// error trap loop
				
				validChoice = true;
				
			}	// error trap loop
				
		} while(!validChoice);	// end of do while loop for menu
				
		return choice;
			
	}	// end of customerMenu method

}// end of Lab6 Driver class
