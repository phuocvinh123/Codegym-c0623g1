package resizeable;

public class Circle extends Resizeable {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double percent) {
        radius *= (1 + percent / 100);
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}
