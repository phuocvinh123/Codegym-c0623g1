package Rectangle;

public class Rectangle {
double width,height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArena() {
        return this.width*this.height;
    }

    public double getPerimeter() {
        return (this.width+this.height)*2;
    }
    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

}
