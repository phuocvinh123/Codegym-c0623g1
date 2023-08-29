package GeometryInterface;

public class ComparableCircle extends Circle implements Comparable{
    public ComparableCircle() {
    }
    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }




    @Override
    public int compareTo(Object obj) {
        ComparableCircle o = (ComparableCircle) obj;
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
