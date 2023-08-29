package circle;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius=1.0;
        color="red";
    }
    public Circle(double radius){
        this.radius=radius;
        color="red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }

    public static void main(String[] args) {
        Circle circle1=new Circle(2.5);
        System.out.println("radius: "+circle1.getRadius());
        System.out.println("area: "+circle1.getArea());
    }
}
