package factoryMethod;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {
    private int xMax = 0;
    private int yMax = 0;
    private List<Shape> shapes;

    public Screen(int xMax, int yMax) {
	this.xMax = Math.abs(yMax);
	this.yMax = Math.abs(yMax);
	shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape.ShapeType shape) throws CustomException {
	try (Scanner inputScanner = new Scanner(System.in)) {

	    int noOfSides = 0;
	    if (shape == Shape.ShapeType.RECTANGLE || shape == Shape.ShapeType.POLYGON) {
		noOfSides = 2;
	    } else {
		noOfSides = 1;
	    }

	    System.out.println("Enter X and Y Coordinates of origin for the shape :");
	    double xCoordinate = inputScanner.nextDouble();
	    double yCoordinate = inputScanner.nextDouble();

	    List<Double> sides = new ArrayList<>(noOfSides);
	    for (int i = 0; i < noOfSides; i++) {
		if (shape == Shape.ShapeType.POLYGON) {
		    System.out.print("Enter the number of sides in the " + shape + " : ");
		} else {
		    System.out.print("Enter the length of side " + (i + 1) + " for " + shape + " : ");
		}

		Double side = inputScanner.nextDouble();
		sides.add(side);
	    }

	    Point p = new Point(xCoordinate, yCoordinate);
	    Shape newShape = ShapeFactory.createShape(shape, p, sides);

	    boolean isShapeInbound = isShapeInbound(newShape);

	    if (isShapeInbound) {
		System.out.println("Added " + shape + " at origin (" + p.getX() + "," + p.getY() + ")\n");
		shapes.add(newShape);
	    } else {

		throw new CustomException(
			"Cannot add " + shape + " to screen : Shape out of bounds for (" + xMax + "," + yMax + ")\n");

	    }

	} catch (Exception e) {
	    throw new CustomException("Cannot create the shape");
	}

    }

    public Shape getShape(int index) throws CustomException {
	if (shapes.size() == 0) {
	    throw new CustomException("No shapes on screen to be fetched");
	}

	return shapes.get(index);
    }

    public void deleteAllShapeTypes(Shape.ShapeType shapeType) {
	for (int i = 0; i < shapes.size(); i++) {
	    Shape.ShapeType currentShapeType = shapes.get(i).getShapeType();
	    if (currentShapeType == shapeType) {
		shapes.remove(i);
	    }
	}
    }

    public boolean isShapeInbound(Shape shape) {
	if (shape == null)
	    return false;
	List<Point> allShapeVertex = shape.getVertexes();
	if (allShapeVertex.size() == 0 || allShapeVertex == null)
	    return false;

	for (Point point : allShapeVertex) {
	    if (point.getX() > xMax || point.getY() > yMax || point.getX() < 0 || point.getY() < 0)
		return false;
	}

	return true;
    }
}
