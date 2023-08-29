package colorable;

public class Rectangle extends Shape implements Colorable{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
