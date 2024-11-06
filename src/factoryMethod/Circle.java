package factoryMethod;



import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {
    private Point origin;
    private static double PI = Math.PI;
    private double radius;
    private List<Integer> sides = new ArrayList<Integer>();
    private List<Point> shapeVertexes;
    private long timestamp;

    public Circle(Point origin2, List<Double> parameters) throws CustomException {
	if (origin == null || parameters == null) {
	    throw new CustomException("Origin or parameter list is null");
	}
	this.setOrigin(origin2);
	this.setTimestamp(new java.util.Date().getTime());
	makeVertexes();
    }

    private void makeVertexes() {

	Point p1 = new Point(origin.getX(), origin.getY() - sides.get(0));
	Point p2 = new Point(origin.getX() + sides.get(0), origin.getY());
	Point p3 = new Point(origin.getX(), origin.getY() + sides.get(0));
	Point p4 = new Point(origin.getX() - sides.get(0), origin.getY());

	shapeVertexes.add(p1);
	shapeVertexes.add(p2);
	shapeVertexes.add(p3);
	shapeVertexes.add(p4);
    }

    public List<Point> getVertexes() {
	List<Point> copyShapeVertexes = new ArrayList<Point>();
	for (Point p : shapeVertexes) {
	    copyShapeVertexes.add(p);
	}
	return copyShapeVertexes;
    }

    public Shape.ShapeType getShapeType() {
	return Shape.ShapeType.CIRCLE;
    }

    @Override
    public double getArea() {
	// TODO Auto-generated method stub
	return PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double getPerimeter() {
	// TODO Auto-generated method stub
	return 2 * PI * getRadius();
    }

    @Override
    public Point getOrigin() {
	// TODO Auto-generated method stub
	return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
	// TODO Auto-generated method stub
	return false;
    }

    public void setOrigin(Point origin) {
	this.origin = origin;
    }

    public long getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
    }

    public double getRadius() {
	return radius;
    }

    public void setRadius(double radius) {
	this.radius = radius;
    }
}

