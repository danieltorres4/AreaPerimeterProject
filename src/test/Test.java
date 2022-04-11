/*
 * Sergio Daniel Sanchez Torres
 * AgileThought Java Internship
 * Area and Perimeter
 */

package test;

import java.util.Scanner;
import data.*;
import domain.*;
import exceptions.*;

public class Test {
	public static void main(String[] args) {
		int option = 0;
		int figure = 0;
		String directory, fn;
		Boolean exit = false;
		String filename;
		IDataAccess access = new DataAccessImp();
		Scanner console = new Scanner(System.in);
		
		while(exit == false) {
			System.out.println("\nAREA AND PERIMETER\n\t1. New operation\n\t2. Open files\n\t3- Exit");
			option = Integer.parseInt(console.nextLine());
			
			switch (option) {
			case 1:
				option = 0;
				System.out.println("\nYou've chosen NEW OPERATION\nChoose an option:\n\t1. Circle\n\t2. Square\n\t3. Rectangle\n\t"
						+ "4. Equilateral triangle\n\t5. Isocels triangle");
				figure = Integer.parseInt(console.nextLine());
				
				switch (figure) {
				/*
				 * CIRCLE
				 */
				case 1:
					double radius;
					System.out.println("Radius: ");
					radius = Double.parseDouble(console.nextLine());
					Figure circle = new Circle(radius);
					System.out.println("Enter filename (without extension): ");
					filename = console.nextLine();
					
					try {
						filename = filename + ".txt";
						access.createDirectory(filename); 
						access.writing(filename, circle.getContent());
					} catch (DataAccessExc e) {
						e.printStackTrace(System.out);
					}
					
					break;
				
				/*
				 * SQUARE
				 */
				case 2:
					double side;
					System.out.println("Side: ");
					side = Double.parseDouble(console.nextLine());
					Figure square = new Square(side);
					System.out.println("Enter filename (without extension): ");
					filename = console.nextLine();
					
					try {
						filename = filename + ".txt";
						access.createDirectory(filename); 
						access.writing(filename, square.getContent());
					} catch (DataAccessExc e) {
						e.printStackTrace(System.out);
					}
					break;
					
				/*
				 * RECTANGLE	
				 */
				case 3:
					double base, height;
					System.out.println("Base: ");
					base = Double.parseDouble(console.nextLine());;
					System.out.println("Height: ");
					height = Double.parseDouble(console.nextLine());
					Figure rectangle = new Rectangle(base, height);
					System.out.println("Enter filename (without extension): ");
					filename = console.nextLine();
					
					try {
						filename = filename + ".txt";
						access.createDirectory(filename); 
						access.writing(filename, rectangle.getContent());
					} catch (DataAccessExc e) {
						e.printStackTrace(System.out);
					}
					break;
				
				/*
				 * EQUILATERAL TRIANGLE	
				 */
				case 4:
					double equilateralSide;
					System.out.println("Base: ");
					equilateralSide = Double.parseDouble(console.nextLine());
					Figure equilateralTriangle = new EquilateralTriangle(equilateralSide);
					System.out.println("Enter filename (without extension): ");
					filename = console.nextLine();
					
					try {
						filename = filename + ".txt";
						access.createDirectory(filename); 
						access.writing(filename, equilateralTriangle.getContent());
					} catch (DataAccessExc e) {
						e.printStackTrace(System.out);
					}
					break;
				
				/*
				 * ISOCELS TRIANGLE	
				 */
				case 5:
					double isocelsBase, isocelsSide;
					System.out.println("Base: ");
					isocelsBase = Double.parseDouble(console.nextLine());
					System.out.println("Side: ");
					isocelsSide = console.nextDouble();
					Figure isocelsSideTriangle = new IsocelsTriangle(isocelsBase, isocelsSide);
					System.out.println("Enter filename (without extension): ");
					filename = console.nextLine();
					
					try {
						filename = filename + ".txt";
						access.createDirectory(filename); 
						access.writing(filename, isocelsSideTriangle.getContent());
					} catch (DataAccessExc e) {
						e.printStackTrace(System.out);
					}
					break;
					
				default:
					System.out.println("Invalid option :(\nTRY AGAIN");
					break;
				}
				
				break;
			
			/*
			 * OPEN FILES 
			 */
			case 2:
				System.out.println("\nYou've chosen OPEN FILES\n");
				System.out.println("\nChoose an option: \n");
				try {
					access.listDirectories("2022");
					System.out.println("\nChoose a directory: ");
					directory = console.nextLine();
					System.out.println("Choose a file (without extension): ");
					fn = console.nextLine();
					
					access.searching(directory, fn);
					access.openFile(fn);
					
				} catch (DataReadoutExc e) {
					e.printStackTrace(System.out);
				} catch (DataAccessExc e) {
					e.printStackTrace(System.out);
				}
				break;
			
			/*
			 * END CASE
			 */
			case 3:
				System.out.println("\nSEE YOU LATER!");
				exit = true;
				break;
			
			default:
				System.out.println("Invalid option :(\nTRY AGAIN");
				break;
			}
		}
		
		console.close();
	}
}
