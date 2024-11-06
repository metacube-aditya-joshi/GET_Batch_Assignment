package factoryMethod;

import java.util.Scanner;

public class Main {
    static Screen screen;

    public static void main(String[] args) throws CustomException {

	try (Scanner inputScanner = new Scanner(System.in);) {
	    System.out.println("Enter Screen Size ->");
	    System.out.print("Length in x axis : ");
	    int xMax = inputScanner.nextInt();
	    System.out.print("Length in y axis : ");
	    int yMax = inputScanner.nextInt();
	    System.out.println();

	    screen = new Screen(xMax, yMax);
	    boolean repeatMenu = true;
	    while (repeatMenu) {
		System.out.println("--------------Shapes Menu-------------- ");
		System.out.println("1. Add shape");
		System.out.println("2. Get Shape");
		System.out.println("3. Remove a particular type of shape");
		System.out.println("4. Exit");
		System.out.println("-----------------------------------------");
		System.out.println("Enter Choice :");
		int choice = inputScanner.nextInt();

		if (choice == 1) {
		    addShape(inputScanner);
		} else if (choice == 2) {
		    System.out.println("Enter the number of the shape you want to fetch :");
		    int index = inputScanner.nextInt() - 1;
		    screen.getShape(index);
		} else if (choice == 3) {
		    deleteShape(inputScanner);
		} else if (choice == 4) {
		    repeatMenu = false;
		} else {
		    throw new CustomException("Enter Correct Choice");
		}
	    }

	} catch (Exception e) {
	    throw new CustomException("Error in launching main application");
	}
    }

    private static void addShape(Scanner inputScanner) throws CustomException {
	try (inputScanner) {
	    System.out.println("Enter The type of shape you want to add :");
	    System.out.println("1. Rectangle");
	    System.out.println("2. Square");
	    System.out.println("3. Trianlge");
	    System.out.println("4. Circle");
	    System.out.println("5. Polygon");

	    int shapeType = inputScanner.nextInt();
	    if (shapeType == 1) {
		screen.addShape(Shape.ShapeType.RECTANGLE);
	    } else if (shapeType == 2) {
		screen.addShape(Shape.ShapeType.SQUARE);
	    } else if (shapeType == 3) {
		screen.addShape(Shape.ShapeType.TRIANGLE);
	    } else if (shapeType == 4) {
		screen.addShape(Shape.ShapeType.CIRCLE);
	    } else if (shapeType == 5) {
		screen.addShape(Shape.ShapeType.POLYGON);
	    }

	} catch (Exception e) {
	    throw new CustomException("Error in adding shape");
	}
    }

    private static void deleteShape(Scanner inputScanner) throws CustomException {
	try (inputScanner) {
	    System.out.println("Enter The type of shape you want to delete :");
	    System.out.println("1. Rectangle");
	    System.out.println("2. Square");
	    System.out.println("3. Trianlge");
	    System.out.println("4. Circle");
	    System.out.println("5. Polygon");

	    int shapeType = inputScanner.nextInt();
	    if (shapeType == 1) {
		screen.deleteAllShapeTypes(Shape.ShapeType.RECTANGLE);
	    } else if (shapeType == 2) {
		screen.deleteAllShapeTypes(Shape.ShapeType.SQUARE);
	    } else if (shapeType == 3) {
		screen.deleteAllShapeTypes(Shape.ShapeType.TRIANGLE);
	    } else if (shapeType == 4) {
		screen.deleteAllShapeTypes(Shape.ShapeType.CIRCLE);
	    } else if (shapeType == 5) {
		screen.deleteAllShapeTypes(Shape.ShapeType.POLYGON);
	    }

	} catch (Exception e) {
	    throw new CustomException("Error in deleting shape");
	}

    }
}
