package domain;

public class IsocelsTriangle extends Figure{
	/*
	 * Constructor
	 */
	public IsocelsTriangle(double isocelsBase, double isocelsSide) {
		super(isocelsBase, isocelsSide);
	}
	
	@Override
	public double figureArea() {
		double height = Math.sqrt((Math.pow(this.height, 2)) - ((Math.pow(this.base, 2)) / 2));
		double isocelsArea = (height * this.base) / 2;
		
		return isocelsArea;
		
	}

	@Override
	public double figurePerimeter() {
		double isocelsPerimeter = (2 * (this.base)) + (this.height);
		return isocelsPerimeter;
	}

}
