package factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

    private Point origin;
    private double length;
    private double breadth;
    private long timestamp;
    private List<Integer> sides = new ArrayList<Integer>();
    private List<Point> shapeVertexes;

    public Rectangle(Point origin2, List<Double> parameters) throws CustomException {
	if (origin == null || parameters == null) {
	    throw new CustomException("Origin or parameter list is null");
	}
	this.origin = origin2;
	this.setLength(parameters.get(0));
	this.setLength(parameters.get(1));
	this.setTimestamp(new java.util.Date().getTime());
	makeVertexes();
    }

    private void makeVertexes() {

	Point p1 = new Point(origin.getX(), origin.getY());
	Point p2 = new Point(origin.getX() + sides.get(0), origin.getY());
	Point p3 = new Point(origin.getX() + sides.get(0), origin.getY() + sides.get(1));
	Point p4 = new Point(origin.getX(), origin.getY() + sides.get(1));

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
	return Shape.ShapeType.RECTANGLE;
    }

    @Override
    public double getArea() {

	return getLength() * getBreadth();
    }

    @Override
    public double getPerimeter() {
	// TODO Auto-generated method stub
	return 2 * (getBreadth() + getLength());
    }

    @Override
    public Point getOrigin() {

	return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
	// TODO Auto-generated method stub
	return false;
    }

    public long getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
    }

    public double getLength() {
	return length;
    }

    public void setLength(double length) {
	this.length = length;
    }

    public double getBreadth() {
	return breadth;
    }

    public void setBreadth(double breadth) {
	this.breadth = breadth;
    }

    // Constructor and methods implementation
}

