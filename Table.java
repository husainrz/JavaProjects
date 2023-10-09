
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * Table - Table furniture subclass (superclass is Furniture) contains private attributes for table information
 */

public class Table extends Furniture{// start of Table subclass
	
	public static final double LAMINATE_COST = 0.125;	// Laminate Cost constant
	
	public static final double OAK_COST = 0.25;	// Oak cost constant
	
	public static final int FOUR_CHAIR_REQ = 3000;
	
	public static final int SIX_CHAIR_REQ = 5000;
	
	public static final int FOUR_CHAIRS = 4;
	
	public static final int SIX_CHAIRS = 6;
	
	public static final int EIGHT_CHAIRS = 8;
	
	public static double CHAIR = 495;
	
	public static String LAM = "Laminate";
	
	// instance fields / attributes
	
	private String shape;
	
	// constructors
	// default constructor
	
	public Table() {	// start of default constructor class
		
		shape = "NONE";
		
	}	// end of default constructor class
	
	public Table(String tShape, String material, double area) {	// start of constructor method
		
		shape = tShape;
		
		this.material = material;
		
		this.area = area;
		
	}	// end of constructor method 

	public String getShape() {	// start of getShape getter method 
		return shape;
	}	// end of getShape getter method
	
	public void setShape(String shape) {	// start of setShape setter method 
		this.shape = shape;
	}	// end of setShape setter method 
		
	/**
	 * Create a method that returns a double and calculates the cost of the table
	 * 	The cost of the table is the area of the table * cost of the table 
	 */
	
	@Override
	public double calcCost() {	// start of calculateTableCost method 
		
		// area of table * material cost 
		
		/**
		 * Use counter controlled for loop to go through the object array
		 * Calculate cost by using get methods for area and material 
		 */
		
		if(material == LAM) {
			return area * LAMINATE_COST;
		}else {
			return area * OAK_COST;
		}
		
	}	// end of calculateTableCost method
	
	/**
	 * Create a method that returns a integer and calculates the # of chairs the table can accomodate
	 * If the area of the table is less than 3000 sq. inches, the table can accomodate 4 chairs 
	 * If the area is greater than 3000 sq. inches and less than or equal to 5000 sq. inches the table can accomodate 6 chairs 
	 * If the area is greater than 5000 sq. inches the table can accomodate 8 chairs 
	 */
	
	public int calculateNumChairs() {	// start of calculateNumChairs method
	
		/*
		 * If area is < 3000 sq inches (4 CHAIRS)
		 * If area > 3000 & <= 5000 sq inches (6 CHAIRS)
		 * If area is > 5000 sq inches (8 CHAIRS)
		 */

		if(area <= FOUR_CHAIR_REQ) {
			return FOUR_CHAIRS;
		}else if(area > FOUR_CHAIR_REQ && area <= SIX_CHAIR_REQ) {
			return SIX_CHAIRS;
		}else {
			return EIGHT_CHAIRS;
		}
		
	}	// end of calculateNumChairs method

	@Override
	public String toString() {	// start of toString method
		return "Table [shape=" + shape + "]";
	}	// end of toString method 

}// end of Table subclass
