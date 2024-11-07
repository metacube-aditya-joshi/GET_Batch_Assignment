package factoryMethod;

import java.util.*;

public class Screen {
    public static final double XMAX = 1000;
    public static final double YMAX = 1000;
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        if (shape.getOrigin().getX() < 0 || shape.getOrigin().getX() > XMAX ||
                shape.getOrigin().getY() < 0 || shape.getOrigin().getY() > YMAX) {
            throw new IllegalArgumentException("Shape is out of bounds");
        }
        shapes.add(shape);
    }
    public void displayShapes() {
        if (shapes.isEmpty()) {
            System.out.println("No shapes on the screen.");
        } else {
            for (Shape shape : shapes) {
                shape.display();
                System.out.println("-------------------------------------------------");
            }
        }
    }
    public void deleteShape(Shape shape) {
        shapes.remove(shape);
    }

    public void deleteShapesOfType(Shape.ShapeType type) {
        shapes.removeIf(shape -> shape.getShapeType() == type);
    }

    public List<Shape> getShapesSortedByArea() {
        shapes.sort(Comparator.comparingDouble(Shape::getArea));
        return new ArrayList<>(shapes);
    }

    public List<Shape> getShapesSortedByPerimeter() {
        shapes.sort(Comparator.comparingDouble(Shape::getPerimeter));
        return new ArrayList<>(shapes);
    }

    public List<Shape> getShapesSortedByTimestamp() {
        shapes.sort(Comparator.comparingLong(Shape::getTimestamp));
        return new ArrayList<>(shapes);
    }

    public List<Shape> getShapesSortedByOriginDistance() {
        shapes.sort(Comparator.comparingDouble(shape -> shape.getOrigin().distanceTo(new Point(0, 0))));
        return new ArrayList<>(shapes);
    }

    public List<Shape> getShapesEnclosingPoint(Point point) {
        List<Shape> enclosedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isPointEnclosed(point)) {
                enclosedShapes.add(shape);
            }
        }
        return enclosedShapes;
    }
}
