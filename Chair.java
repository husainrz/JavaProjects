
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * Chair - Chair furniture subclass (superclass is Furniture) contains private attributes for chair information 
 */

public class Chair extends Furniture{	// start of subclass Chair
	
	public static final double CHAIR = 495;	// constant area of a chair
	
	public static final double LAMINATE_COST = 0.125;	// Laminate Cost constant
	
	public static final double OAK_COST = 0.25;	// Oak cost constant
	
	public static String LAM = "Laminate";

	private int numChairs;	// number of chairs for the table
	
	public Chair() {	// start of default constructor method
		
		numChairs = 0;
		
	}	// end of default constructor method
	
	public Chair(int numChairs, String material, double area ) {	// start of Chair constructor method
		this.numChairs = numChairs;
		this.material = material;
		this.area = area;
	}	// end of Chair constructor method

	public int getNumChairs() {	// start of getNumChiars get method
		return numChairs;
	}	// end of getNumChairs get method

	public void setNumChairs(int numChairs) {	// start of setNumChairs set method
		this.numChairs = numChairs;
	}	// end of setNumChairs set method
	
	@Override		
	public double calcCost() {	// start of calcCost override method
		if(material == LAM) {	// start of if statement 
			return area * LAMINATE_COST;
		}else {
			return area * OAK_COST;
		}	// end of if statement 
	}	// end of calcCost override method
	
	@Override
	public String toString() {	// start of toString method
		return "Chair [numChairs=" + numChairs + "]";
	}	// end of toString method

}	// end of subclass Chair
