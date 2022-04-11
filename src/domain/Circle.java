package domain;

//import exceptions.*;

public class Circle extends Figure{
	/*
	 * Constructor
	 */
	public Circle(double radius) {
		super(radius);
	}
	
	/*
	 * Method
	 */
	@Override
	public double figureArea() {
		double circleArea = 0;
		if(this.data > 0) {
			circleArea = (Math.PI) * (Math.pow((this.data), 2));
			//return circleArea;
		} else {
			System.out.println("Radius should be greater than zero");
		}
		
		return circleArea;
	}

	@Override
	public double figurePerimeter() {
		double circlePerimeter = ((Math.PI) * (2 * this.data));
		return circlePerimeter;
		
	}

}
