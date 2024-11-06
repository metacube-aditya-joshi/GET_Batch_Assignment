package factoryMethod;


import java.util.List;

public class ShapeFactory {
    public static Shape createShape(Shape.ShapeType type, Point origin, List<Double> parameters) {
        switch (type) {
            case SQUARE:
                return new Square(origin, parameters);
            case RECTANGLE:
                return new Rectangle(origin, parameters);
            case CIRCLE:
                return new Circle(origin, parameters);
            case TRIANGLE:
                return new Triangle(origin, parameters);
            default:
                throw new IllegalArgumentException("Unsupported shape type");
        }
    }
}