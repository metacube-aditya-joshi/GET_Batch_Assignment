package factoryMethod;

public class Point {
    private double x = 0;
    private double y = 0;

    private final double ORIGIN_X = 0;
    private final double ORIGIN_Y = 0;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
    
    public double distanceFrom(Point p){
        double xDifference = p.getX() - x;
        double yDifference = p.getY() - y;

        double distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
        return distance;
    }
    public double distanceFrom(double x, double y){
        double xDifference = x - this.x;
        double yDifference = y - this.y;

        double distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
        return distance;
    }

    public double distanceFromOrigin(){
        return distanceFrom(ORIGIN_X, ORIGIN_Y);
    }
}

