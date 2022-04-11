package domain;

public abstract class Figure {
	protected double base;
	protected double height;
	protected double data;
	protected double area;
	protected double perimeter;
	public String content;
	
	/*
	 * Constructors
	 */
	protected Figure(double base, double height) {
		this.base = base;
		this.height = height;
		area = figureArea();
		perimeter = figurePerimeter();
		content = "Data: " + base + ". Data: " + height + ". Area: " + area + ". Perimeter: " + perimeter;
		System.out.println("\nOperations are done and will be save in a file");
	}
	
	protected Figure(double data) {
		this.data = data;
		area = figureArea();
		perimeter = figurePerimeter();
		content = "Data: " + data + ". Area: " + area + ". Perimeter: " + perimeter;
		System.out.println("\nOperations are done and will be save in a file");
	}
	
	
	/*
	 * Methods
	 */
	public abstract double figureArea();
	
	public abstract double figurePerimeter();
	
	
	/*
	 * Getter and setter
	 */
	public String getContent() {
		return content;
	}
	
	public String toString() {
		return "Area: " + this.area + ". Perimeter: " + this.perimeter;
	}
}
