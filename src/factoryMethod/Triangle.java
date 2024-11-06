package factoryMethod;


import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape {
    private Point origin;
    private double sideLength;
    private long timestamp;
    private List<Point> vertices = new ArrayList<>();

    public Triangle(Point origin, List<Double> parameters) {
        this.origin = origin;
        this.sideLength = parameters.get(0);
        this.timestamp = System.currentTimeMillis();
        createVertices();
    }

    private void createVertices() {
        vertices.add(new Point(origin.getX(), origin.getY()));
        vertices.add(new Point(origin.getX() + sideLength, origin.getY()));

        double x = origin.getX() + (sideLength * Math.cos(Math.PI / 3));
        double y = origin.getY() + (sideLength * Math.sin(Math.PI / 3));
        vertices.add(new Point(x, y));
    }
    @Override
    public void display() {
        System.out.println("Shape Type: Triangle");
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Origin: (" + origin.getX() + ", " + origin.getY() + ")");
        System.out.print("Vertexes: ");
        for (Point p : vertices) {
            System.out.print("(" + p.getX() + ", " + p.getY() + ") ");
        }
        System.out.println("\nTimestamp: " + timestamp);
    }
    @Override
    public double getArea() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 3 * sideLength;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        // Simplified check (for the sake of brevity)
        return false; // A proper check would require more geometric calculations
    }

    @Override
    public List<Point> getVertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.TRIANGLE;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
