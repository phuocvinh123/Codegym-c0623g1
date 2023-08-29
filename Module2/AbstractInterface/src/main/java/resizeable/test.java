package resizeable;

public class test {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(3.6);
        shapes[1] = new Rectangle(4.2, 5.6);
        shapes[2] = new Square(2.5);

        System.out.println("Pre-resize:");
        for (Resizeable shape : shapes) {
            System.out.println(shape);
        }

        // Resize all shapes by 50%
        for (Resizeable shape : shapes) {
            shape.resize(50);
        }

        System.out.println("Post-resize:");
        for (Resizeable shape : shapes) {
            System.out.println(shape);
        }
    }
}
