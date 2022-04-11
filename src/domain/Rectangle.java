package domain;

public class Rectangle extends Figure{
	/*
	 * Constructor
	 */
	public Rectangle(double base, double height) {
		super(base, height);
	}
	
	@Override
	public double figureArea() {
		double rectangleArea = (this.base) * (this.height); 
		return rectangleArea;
		
	}

	@Override
	public double figurePerimeter() {
		double rectanglePerimeter = ((2) * (this.base)) + ((2) * (this.height)); 
		return rectanglePerimeter;
		
	}

}
