package factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {
    private Point origin;
    private double length;
    private double breadth;
    private long timestamp;
    private List<Point> vertices = new ArrayList<>();

    public Rectangle(Point origin, List<Double> parameters) throws CustomException {
        if(origin==null)
         throw new CustomException("Cannot pass null Origin");

         if(parameters==null || parameters.size()<2)
         throw new CustomException("Cannot pass null Parameters or enter some values in it");
        this.origin = origin;
        this.length = parameters.get(0);
        this.breadth = parameters.get(1);
        this.timestamp = System.nanoTime();
    
        createVertices();
    }

    private void createVertices() {
        vertices.add(new Point(origin.getX(), origin.getY()));
        vertices.add(new Point(origin.getX() + length, origin.getY()));
        vertices.add(new Point(origin.getX() + length, origin.getY() + breadth));
        vertices.add(new Point(origin.getX(), origin.getY() + breadth));
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + breadth);
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        return point.getX() >= origin.getX() && point.getX() <= origin.getX() + length &&
                point.getY() >= origin.getY() && point.getY() <= origin.getY() + breadth;
    }

    @Override
    public List<Point> getVertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public void display() {
        System.out.println("Shape Type: Rectangle");
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Origin: (" + origin.getX() + ", " + origin.getY() + ")");
        System.out.print("Vertexes: ");
        for (Point p : vertices) {
            System.out.print("(" + p.getX() + ", " + p.getY() + ") ");
        }
        System.out.println("\nTimestamp: " + timestamp);
    }
}