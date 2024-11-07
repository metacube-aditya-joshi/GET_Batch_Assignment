package factoryMethod;



import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {
    private Point origin;
    private double radius;
    private long timestamp;

    public Circle(Point origin, List<Double> parameters) throws CustomException {
        if(origin==null)
         throw new CustomException("Cannot pass null Origin");

         if(parameters==null || parameters.size()<1)
         throw new CustomException("Cannot pass null Parameters or enter some values in it");
        this.origin = origin;
        this.radius = parameters.get(0);
        this.timestamp = System.currentTimeMillis();
    }
    @Override
    public void display() {
        System.out.println("Shape Type: Circle");
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Origin: (" + origin.getX() + ", " + origin.getY() + ")");
        System.out.println("Radius: " + radius);
        System.out.println("Timestamp: " + timestamp);
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        double distance = origin.distanceTo(point);
        return distance <= radius;
    }

    @Override
    public List<Point> getVertices() {
        return new ArrayList<>();  // Circle has no vertices
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
