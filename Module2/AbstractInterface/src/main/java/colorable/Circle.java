package colorable;

public class Circle extends Shape implements Colorable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
