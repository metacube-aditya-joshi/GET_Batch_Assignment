package factoryMethod;


import java.util.List;

public class Polygon implements Shape {
    private Point origin;
    private double sideLength;
    private long timestamp;

    public Polygon(Point origin2, List<Double> parameters) throws CustomException {
	if (origin == null || parameters == null) {
	    throw new CustomException("Origin or parameter list is null");
	}
	this.setOrigin(origin2);
	this.setSideLength(parameters.get(0));
	this.setTimestamp(new java.util.Date().getTime());
    }
    public Shape.ShapeType getShapeType(){
        return Shape.ShapeType.POLYGON;
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

    public double getSideLength() {
	return sideLength;
    }

    public void setSideLength(double sideLength) {
	this.sideLength = sideLength;
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
}

