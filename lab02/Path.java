/** A class that represents a path via pursuit curves. */
public class Path {

    // TODO
    private Point currPoint;

    private Point nextPoint;

    public double getCurrX(){
    	return currPoint.getX();
    }

    public double getCurrY(){
    	return currPointY();
    }

    public double getNextX(){
    	return nextPoint.getX();
    }

    public double getNextY(){
    	return nextPoint.getY();
    }

    public Point getCurrentPoint(){
    	return currPoint;
    }

    public void setCurrentPoint(Point point){
    	this.currPoint.setX(point.getX());
    	this.currPoint.setY(point.getY());
    }

    public Path(double x, double y){
    	this.currPoint = new Point(0,0);
    	this.nextPoint = new Point(0,0);
    	this.nextPoint.setX(x);
    	this.nextPoint.setY(y);

    }

    public void iterate(double dx, double dy){
    	this.currPoint = nextPoint;
    	this.nextPoint = new Point(dx + currPoint.getX(), dy + currPoint.getY());
    }

}
