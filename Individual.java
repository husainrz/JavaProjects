
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * Individual - Individual customer subclass (superclass is Customer) contains private attributes for customer information 
 */

import java.time.LocalDate;

public class Individual extends Customer{	// start of Individual subclass 
	
	private String accNum;
	private String cardType;
	private String cardNum;
	private int expMon;
	private int expYear;
	
	public Individual() {	// start of default constructor method
		
		accNum = "NONE";
		cardType = "NONE";
		cardNum = "NONE";
		expMon = 0;
		expYear = 0;
		
	}	// end of default constructor method
	
	public Individual(String tName, String tEmail, String tPhoneNum, String tAccNum, String tCardType, String tCardNum, int tExpMon, int tExpYear) { // start of constructor method
		
		name = tName;
		email = tEmail;
		phoneNum = tPhoneNum;
		accNum = tAccNum;
		cardType = tCardType;
		cardNum = tCardNum;
		expMon = tExpMon;
		expYear = tExpYear;
		
	}	// end of constructor method

	public String getAccNum() {	// start of getAccNum get method
		return accNum;
	}	// end of getAccNum get method
		
	public void setAccNum(String accNum) {	// start of setAccNum set method
		this.accNum = accNum;
	}	// end of setAccNum set method

	public String getCardType() {	// start of getCardType get method
		return cardType;
	}// end of getCardType get method 

	public void setCardType(String cardType) {	// start of setCardType set method 
		this.cardType = cardType;
	}	// end of setCardType set method

	public String getCardNum() {	// start of getCardNum get method
		return cardNum;
	}	// end of getCardNum get method
	
	public void setCardNum(String cardNum) {	// start of setCardNum set method
		this.cardNum = cardNum;	
	}	// end of setCardNum set method

	public int getExpMon() {	// start of getExpMon get method
		return expMon;
	}		// end of getExpMon get method

	public void setExpMon(int expMon) {	// start of setExpMon set method
		this.expMon = expMon;
	}	// end of setExpMon set method

	public int getExpYear() {	// start of getExpYear get method
		return expYear;	
	}	// end of getExpYear get method

	public void setExpYear(int expYear) {	// start of setExpYear set method
		this.expYear = expYear;
	}	// end of setExpYear set method
	
	/**
	 * Method that returns a String that has only the last four digits of the 
	 * credit card number 
	 */
	
	public String printNum() {	// start of printNum method for edited credit card number 
		
		cardNum = cardNum.substring(cardNum.length()-4);
		
		return cardNum;
		
	}	// end of printNum method for edited credit card number 
	
	/**
	 * Must have a method that returns a Boolean value that determines 
	 * if the credit card entered is expired based on today's date
	 */
	
	public boolean isExpired() {	// start of isExpired method for credit card validity
		
		int iMon, iYear;
		
		LocalDate today = LocalDate.now();
		
		iMon = today.getMonthValue();
		
		iYear = today.getYear();
		
		if(iYear < expYear) { // if loop for expiration date validity
			System.out.println("Your card information is up to date!");
			return false;
		} // if loop for expiration date validity
		
		if(iYear > expYear) { // if loop for expiration date validity
			System.out.println("The card you are using has expired, please enter a new card");
			return true;
		}// if loop for expiration date validity
		
		return false;
		
	}	// end of isExpired method for credit card validity
		
	@Override
	public String toString() { // start of toString method
				
		return String.format("%s%nTheir account number is: %s%nThey have a %s ending in %s%n", super.toString(), accNum, cardType, printNum(), isExpired());
		
	}	// end of toString method	

}// end of Individual subclass
