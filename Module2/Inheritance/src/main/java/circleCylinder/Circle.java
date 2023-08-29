package circleCylinder;

public class Circle {
    private String color;
    private double radius;

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public Circle() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
   public double getCircleArea(){
        return Math.PI*radius*radius;
   }

    @Override
    public String toString() {
        return "color: "+ color+" radius:" +radius;
    }
}
