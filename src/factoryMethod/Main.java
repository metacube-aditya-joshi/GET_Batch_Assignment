package factoryMethod;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Screen screen = new Screen();

    public static void main(String[] args) throws CustomException {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            try {
                switch (choice) {
                    case 1:
                        createShape();
                        break;
                    case 2:
                        deleteShape();
                        break;
                    case 3:
                        deleteShapesOfType();
                        break;
                    case 4:
                        listShapesSortedByArea();
                        break;
                    case 5:
                        listShapesSortedByPerimeter();
                        break;
                    case 6:
                        listShapesSortedByTimestamp();
                        break;
                    case 7:
                        listShapesSortedByOriginDistance();
                        break;
                    case 8:
                        queryShapesEnclosingPoint();
                        break;
                    case 9:
                        screen.displayShapes();
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new CustomException("Error while selecting from menu " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Graphics Library Menu ---");
        System.out.println("1. Create a Shape");
        System.out.println("2. Delete a Shape");
        System.out.println("3. Delete Shapes of a Specific Type");
        System.out.println("4. List Shapes Sorted by Area");
        System.out.println("5. List Shapes Sorted by Perimeter");
        System.out.println("6. List Shapes Sorted by Timestamp");
        System.out.println("7. List Shapes Sorted by Origin Distance");
        System.out.println("8. Query Shapes Enclosing a Point");
        System.out.println("9. Display Shapes");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createShape() throws CustomException {

        System.out.println("Enter Shape Type (1. Square, 2. Rectangle, 3. Circle, 4. Triangle): ");
        int shapeTypeChoice = scanner.nextInt();

        if(shapeTypeChoice<0 || shapeTypeChoice>4)
         throw new CustomException("Choose Correct Shape type");
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the X coordinate of the origin: ");
        double x = scanner.nextDouble();
        if(x<0 || x>screen.XMAX)
        throw new CustomException("Enter Correct X coordinate");
        System.out.print("Enter the Y coordinate of the origin: ");
        double y = scanner.nextDouble();
        if(y<0 || y>screen.YMAX)
        throw new CustomException("Enter Correct Y coordinate");
        scanner.nextLine(); // Consume newline

        Point origin = new Point(x, y);
        List<Double> parameters = new ArrayList<>();

        try {
            switch (shapeTypeChoice) {
                case 1: // Square
                    System.out.print("Enter the side length of the square: ");
                    parameters.add(scanner.nextDouble());
                    screen.addShape(ShapeFactory.createShape(Shape.ShapeType.SQUARE, origin, parameters));
                    break;
                case 2: // Rectangle
                    System.out.print("Enter the length of the rectangle: ");
                    parameters.add(scanner.nextDouble());
                    System.out.print("Enter the breadth of the rectangle: ");
                    parameters.add(scanner.nextDouble());
                    screen.addShape(ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, origin, parameters));
                    break;
                case 3: // Circle
                    System.out.print("Enter the radius of the circle: ");
                    parameters.add(scanner.nextDouble());
                    screen.addShape(ShapeFactory.createShape(Shape.ShapeType.CIRCLE, origin, parameters));
                    break;
                case 4: // Triangle
                    System.out.print("Enter the side length of the triangle: ");
                    parameters.add(scanner.nextDouble());
                    screen.addShape(ShapeFactory.createShape(Shape.ShapeType.TRIANGLE, origin, parameters));
                    break;
                default:
                    System.out.println("Invalid choice for shape type.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Error while selecting shape" +  e.getMessage());
        }
        System.out.println("Shape created and added to the screen.");
    }

    private static void deleteShape() throws CustomException {
        System.out.println("Enter Shape Type to delete (1. Square, 2. Rectangle, 3. Circle, 4. Triangle): ");
        int shapeTypeChoice = scanner.nextInt();
        if(shapeTypeChoice<0 || shapeTypeChoice>4)
         throw new CustomException("Choose Correct Shape type");
        scanner.nextLine(); // Consume newline
        Shape.ShapeType shapeType = getShapeTypeFromInput(shapeTypeChoice);

        if(shapeType.equals(null))
         throw new CustomException("Choose Correct Shape type");

        List<Shape> shapesToDelete = new ArrayList<>();
        for (Shape shape : screen.getShapesSortedByTimestamp()) {
            if (shape.getShapeType() == shapeType) {
                shapesToDelete.add(shape);
            }
        }

        if (shapesToDelete.isEmpty()) {
            throw new CustomException("No shapes of this type found.");
        } else {
            for (Shape shape : shapesToDelete) {
                screen.deleteShape(shape);
                System.out.println("Shape deleted.");
            }
        }
    }

    private static void deleteShapesOfType() throws CustomException {
        System.out.println("Enter Shape Type to delete all shapes (1. Square, 2. Rectangle, 3. Circle, 4. Triangle): ");
        int shapeTypeChoice = scanner.nextInt();
        if(shapeTypeChoice<0 || shapeTypeChoice>4)
         throw new CustomException("Choose Correct Shape type");
        scanner.nextLine(); // Consume newline
        Shape.ShapeType shapeType = getShapeTypeFromInput(shapeTypeChoice);

        if(shapeType.equals(null))
        throw new CustomException("Choose Correct Shape type");


        screen.deleteShapesOfType(shapeType);
        System.out.println("All shapes of type " + shapeType + " deleted.");
    }

    private static void listShapesSortedByArea() {
        List<Shape> shapes = screen.getShapesSortedByArea();
        printShapeList(shapes, "Area");
    }

    private static void listShapesSortedByPerimeter() {
        List<Shape> shapes = screen.getShapesSortedByPerimeter();
        printShapeList(shapes, "Perimeter");
    }

    private static void listShapesSortedByTimestamp() {
        List<Shape> shapes = screen.getShapesSortedByTimestamp();
        printShapeList(shapes, "Timestamp");
    }

    private static void listShapesSortedByOriginDistance() {
        List<Shape> shapes = screen.getShapesSortedByOriginDistance();
        printShapeList(shapes, "Origin Distance");
    }

    private static void queryShapesEnclosingPoint() throws CustomException {
        System.out.print("Enter the X coordinate of the point: ");
        double x = scanner.nextDouble();
        if(x<0 || x>screen.XMAX)
        throw new CustomException("Enter Correct X coordinate");
        System.out.print("Enter the Y coordinate of the point: ");
        double y = scanner.nextDouble();
        if(y<0 || y>screen.YMAX)
        throw new CustomException("Enter Correct Y coordinate");
        Point point = new Point(x, y);

        List<Shape> shapes = screen.getShapesEnclosingPoint(point);
        if (shapes.isEmpty()) {
            System.out.println("No shapes enclose the point.");
        } else {
            printShapeList(shapes, "Enclosing the point");
        }
    }

    private static void printShapeList(List<Shape> shapes, String criteria) {
        if (shapes.isEmpty()) {
            System.out.println("No shapes to display.");
        } else {
            System.out.println("Shapes sorted by " + criteria + ":");
            for (Shape shape : shapes) {
                System.out.println("Shape: " + shape.getShapeType() +
                        ", Area: " + shape.getArea() +
                        ", Perimeter: " + shape.getPerimeter() +
                        ", Timestamp: " + shape.getTimestamp());
            }
        }
    }

    private static Shape.ShapeType getShapeTypeFromInput(int choice) {
        switch (choice) {
            case 1:
                return Shape.ShapeType.SQUARE;
            case 2:
                return Shape.ShapeType.RECTANGLE;
            case 3:
                return Shape.ShapeType.CIRCLE;
            case 4:
                return Shape.ShapeType.TRIANGLE;
            default:
                System.out.println("Invalid shape type.");
                return null;
        }
    }
}
