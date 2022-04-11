package domain;

public class EquilateralTriangle extends Figure{
	/*
	 * Constructor
	 */
	public EquilateralTriangle(double side) {
		super(side);
	}

	@Override
	public double figureArea() {
		double height;
		double triangleArea;
		
		height = Math.sqrt((Math.pow(this.data, 2)) - ((Math.pow(this.data, 2)) / 2));
		triangleArea = (height * this.data) / 2;
		
		return triangleArea;
		
	}

	@Override
	public double figurePerimeter() {
		double trianglePerimeter;
		trianglePerimeter = (3 * (this.data));
		
		return trianglePerimeter;
		
	}
}
