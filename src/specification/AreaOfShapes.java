package specification;

import java.util.Scanner;

class AreaOfShapes {
    double calculatedArea;
    final static double PI = 3.14;
//    enum Shapes {
//	  LOW,
//	  MEDIUM,
//	  HIGH
//	}

    double area(double width, double height, String shape) {

	if (width == 0 || height == 0)
	    throw new ArithmeticException("Invalid Value of Width or Height");

	calculatedArea = width * height;

	if (shape.equalsIgnoreCase("Triangle"))
	    setCalculatedArea(calculatedArea * 0.5);

	else if (shape.equalsIgnoreCase("rectangle"))
	    setCalculatedArea(calculatedArea);

	return calculatedArea;
    }

    double area(double width, String shape) {
	if (width == 0)
	    throw new ArithmeticException("Invalid Value of Width");
	if (shape.equalsIgnoreCase("square"))
	    setCalculatedArea(width * width);

	else if (shape.equalsIgnoreCase("circle"))
	    setCalculatedArea(PI * width * width);

	return calculatedArea;
    }

    void menu(Scanner inputStream) {

	System.out.println("Enter the Shape  : ");
	System.out.println("1. Traingle ");
	System.out.println("2. Rectangle ");
	System.out.println("3. Square");
	System.out.println("4. Circle ");
	System.out.println("5. Exit");
	int option = inputStream.nextInt();

	functionSelector(option, inputStream);
    }

    private void functionSelector(int choice, Scanner inputStream) {

	switch (choice) {
	case 1: {
	    System.out.println("Enter Width and Height :");
	    double width = inputStream.nextInt();
	    double height = inputStream.nextInt();
	    System.out.println(area(width, height, "Triangle"));
	    break;
	}
	case 2: {
	    System.out.println("Enter Width and Height :");
	    double width = inputStream.nextInt();
	    double height = inputStream.nextInt();
	    System.out.println(area(width, height, "Rectangle"));
	    break;
	}
	case 3: {
	    System.out.println("Enter Width  :");
	    double width = inputStream.nextInt();

	    System.out.println(area(width, "Square"));
	    break;
	}
	case 4: {
	    System.out.println("Enter Width  :");
	    double width = inputStream.nextInt();

	    System.out.println(area(width, "Circle"));
	    break;
	}
	case 5: {
	    break;
	}

	default: {
	    System.out.println("Invalid Choice!!");
	    break;
	}
	}

    }

    /**
     * @return the calculatedArea
     */
    public double getCalculatedArea() {
	return calculatedArea;
    }

    /**
     * @param calculatedArea the calculatedArea to set
     */
    public void setCalculatedArea(double calculatedArea) {
	this.calculatedArea = calculatedArea;
    }

}
