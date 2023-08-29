package colorable;

public class test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Circle(2);

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea());

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println();
        }

    }
}
