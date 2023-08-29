package resizeable;

public class Square extends Resizeable{
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public void resize(double percent) {
        side *= (1 + percent / 100);
    }

    @Override
    public String toString() {
        return "Square [side=" + side + "]";
    }
}
