
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * Customer - Customer superclass that contains 3 protected attributes for customer information 
 */

public class Customer {// start of Customer superclass

	protected String name;
	protected String email;
	protected String phoneNum;
	
	private String accNum = "NONE";
	
	public Customer()	{	// start of default constructor
		
		name = "NONE";
		email = "NONE";
		phoneNum = "NONE";
		accNum = "NONE";
		
	}	// end of default constructor 
	
	public Customer(String tName, String tEmail, String tPhoneNum) {	// start of constructor 
		
		name = tName;
		email = tEmail;
		phoneNum = tPhoneNum;
		
	}	// end of constructor method 

	public String getName() {	// start of getName get method
		return name;
	}	// end of getName get method

	public void setName(String name) {	// start of setName set method
		this.name = name;
	}	// end of setName set method

	public String getEmail() {	// start of getEmail get method
		return email;
	}	// end of getEamil get method

	public void setEmail(String email) {	// start of setEamil set method
		this.email = email;
	}	// end of setEmail set method

	public String getPhoneNum() {		// start of getPhoneNum get method
		return phoneNum;
	}	// end of getPhoneNum get method
	
	public void setPhoneNum(String phoneNum) {	// start of setPhoneNum set method
		this.phoneNum = phoneNum;
	}	// end of setPhoneNum set method

	public String getAccNum() {	// start of getAccNum get method
		return accNum;
	}	// end of getAccNum get method

	public void setAccNum(String accNum) {	// start of setAccNum set method
		this.accNum = accNum;	
	}	// end of setAccNum set method
		
	@Override
	public String toString() {	// start of toString method
				
		return String.format("Customer Name: %s %nEmail Address: %s %nPhone Number: %s", name, email, phoneNum);
		
	}	// end of toString method	
	
}// end of Customer superclass
