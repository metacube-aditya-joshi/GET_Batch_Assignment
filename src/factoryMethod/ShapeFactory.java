package factoryMethod;

import java.util.List;

import factoryMethod.Shape.ShapeType;



public class ShapeFactory {
    public static Shape createShape(Shape.ShapeType type, Point origin, List<Double> parameters) {
	Shape shape = null;
	try {
	    if (type.equals(ShapeType.SQUARE)) {
		shape = new Square(origin, parameters);
	    } else if (type.equals(ShapeType.RECTANGLE)) {
		shape = new Rectangle(origin, parameters);
	    } else if (type.equals(ShapeType.CIRCLE)) {
		shape = new Circle(origin, parameters);
	    } else if (type.equals(ShapeType.TRIANGLE)) {
		shape = new Triangle(origin, parameters);
	    } else {
		shape = new Polygon(origin, parameters);
	    }

	} catch (Exception e) {
	    // TODO: handle exception
	}
	return shape;
    }
}
