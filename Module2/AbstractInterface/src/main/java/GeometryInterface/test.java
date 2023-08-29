package GeometryInterface;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle("blue",true,3.6);
        circles[1] = new ComparableCircle("red",false,2.3);
        circles[2] = new ComparableCircle("indigo", false, 3.5);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle.toString());
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle.toString());
        }
    }
}
