package circleCylinder;

public class Cylinder extends Circle{
private  double height;
    public Cylinder(String color, double radius) {
        super(color, radius);
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public Cylinder() {

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getCylinderArea(){
        return getCircleArea()*height;
    }

    @Override
    public String toString() {
        return super.toString()+" height: "+height;
    }
}
