
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * Commercial - Commercial customer subclass (superclass is Customer) contains private attributes for customer information 
 */

public class Commercial extends Customer{// start of Commercial subclass
	
	private String accNum;
	private String accType;
	
	public Commercial() {	// start of Commercial default constructor
		
		accNum = "NONE";
		accType = "NONE";
			
	}	// end of default constructor 
	
	public Commercial(String tName, String tEmail, String tPhoneNum, String tAccNum, String tAccType) {	// start of Commercial constructor 
		
		name = tName;
		email = tEmail;
		phoneNum = tPhoneNum;
		accNum = tAccNum;
		accType = tAccType;
		
	}	// end of Commercial constructor method

	@Override
	public String getAccNum() {	// start of getAccNum get method
		return accNum;
	}	// end of getAccNum get method

	public void setAccNum(String accNum) {	// start of setAccNum set method
		this.accNum = accNum;
	}	// end of setAccNum set method 

	public String getAccType() {	// start of getAccType get method
		return accType;
	}	// end of getAccType get method
	
	public void setAccType(String accType) {	// start of setAccType set method
		this.accType = accType;
	}	// end of setAccType set method

	@Override
	public String toString() {	// start of toString method

		return String.format("%s%nAccount Number: %s and they are a %s account", super.toString(), accNum, accType);
	
	}	// end of toString method	

}// end of Commercial subclass
