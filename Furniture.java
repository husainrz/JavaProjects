
/**
 * @author Husain Rizvi
 * CMSY-166-N090
 * Furniture - Furniture superclass for tables and chairs
 * SuperClass
 */

public abstract class Furniture {	// start of abstract class Furniture

	protected String material;
	protected double area;
	
	public Furniture() { // start of default constructor Furniture
		
		material = "NONE";
		area = 0;
		
	}	// end of default constructor Furniture

	public Furniture(String material, double area) {	// start of argument constructor Furniture 
		
		super();
		this.material = material;
		this.area = area;
	
	}	// end of argument constructor Furniture 

	public String getMaterial() {	// start of getMaterial get method
		return material;
	}	// end of getMaterial get method

	public void setMaterial(String material) {	// start of setMaterial set method
		this.material = material;
	}	// end of setMaterial set method
	
	public double getArea() {	// start of getArea get method
		return area;
	}	// end of getArea get method

	public void setArea(double area) {	// start of setArea set method
		this.area = area;
	}	// end of setArea set method
	
	public abstract double calcCost();	// abstract method for calculating cost of furniture 

	@Override
	public String toString() {	// start of toString method
		return "Furniture [material=" + material + ", area=" + area + "]";
	}	// end of toString method
		
	
} // end of abstract class Furniture 
