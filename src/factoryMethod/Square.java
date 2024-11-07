package factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Square implements Shape {
    private Point origin;
    private double sideLength;
    private long timestamp;
    private List<Point> vertices = new ArrayList<>();

    public Square(Point origin, List<Double> parameters) throws CustomException {
        if(origin==null)
         throw new CustomException("Cannot pass null Origin");

         if(parameters==null || parameters.size()<1)
         throw new CustomException("Cannot pass null Parameters or enter some values in it");
        this.origin = origin;
        this.sideLength = parameters.get(0);
        this.timestamp = System.nanoTime();
    
        createVertices();
    }

    private void createVertices() {
        vertices.add(new Point(origin.getX(), origin.getY()));
        vertices.add(new Point(origin.getX() + sideLength, origin.getY()));
        vertices.add(new Point(origin.getX() + sideLength, origin.getY() + sideLength));
        vertices.add(new Point(origin.getX(), origin.getY() + sideLength));
    }

    @Override
    public void display() {
        System.out.println("Shape Type: Square");
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
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        return point.getX() >= origin.getX() && point.getX() <= origin.getX() + sideLength &&
                point.getY() >= origin.getY() && point.getY() <= origin.getY() + sideLength;
    }

    @Override
    public List<Point> getVertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.SQUARE;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}

