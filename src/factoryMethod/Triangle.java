package factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape {
    private Point origin;
    private double length;
    private List<Integer> sides = new ArrayList<Integer>();
    private List<Point> shapeVertexes;
    private long timestamp;

    public Triangle(Point origin2, List<Double> parameters) throws CustomException {
	if (origin == null || parameters == null) {
	    throw new CustomException("Origin or parameter list is null");
	}
	this.setOrigin(origin2);
	this.setLength(parameters.get(0));
	this.setTimestamp(new java.util.Date().getTime());
	makeVertexes();
    }

    public Shape.ShapeType getShapeType() {
	return Shape.ShapeType.TRIANGLE;
    }

    private void makeVertexes() {

	double side = sides.get(0);

	Point p1 = new Point(origin.getX(), origin.getY());
	Point p2 = new Point(origin.getX() + side, origin.getY());

	double p3x = origin.getX() + (side * Math.cos((Math.PI * 1) / 3));
	double p3y = origin.getY() + (side * Math.sin((Math.PI * 2) / 3));
	Point p3 = new Point(p3x, p3y);

	shapeVertexes.add(p1);
	shapeVertexes.add(p2);
	shapeVertexes.add(p3);
    }

    @Override
    public double getArea() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public double getPerimeter() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public Point getOrigin() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
	// TODO Auto-generated method stub
	return false;
    }

    public void setOrigin(Point origin) {
	this.origin = origin;
    }

    public double getLength() {
	return length;
    }

    public void setLength(double length) {
	this.length = length;
    }

    public long getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
    }

    @Override
    public List<Point> getVertexes() {
	// TODO Auto-generated method stub
	return null;
    }

    // Constructor and methods implementation
}

