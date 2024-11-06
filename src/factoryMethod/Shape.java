package factoryMethod;

import java.util.List;

public interface Shape {
    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isPointEnclosed(Point point);

    enum ShapeType {
        SQUARE,
        RECTANGLE,
        CIRCLE,
        TRIANGLE,
        POLYGON
    }

    List<Point> getVertices();
    ShapeType getShapeType();
    long getTimestamp();
    void display();
}
