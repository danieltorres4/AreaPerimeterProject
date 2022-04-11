package domain;

public class Square extends Figure{
	/*
	 * Constructor
	 */
	public Square(double side) {
		super(side);
	}
	
	@Override
	public double figureArea() {
		double squareArea = (this.data) * (this.data); 
		return squareArea;
		
	}

	@Override
	public double figurePerimeter() {
		double squarePerimeter = (4) * (this.data); 
		return squarePerimeter;
		
	}

}
