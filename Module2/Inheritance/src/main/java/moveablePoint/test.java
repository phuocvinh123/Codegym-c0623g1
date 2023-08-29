package moveablePoint;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Point point=new Point();
        point.setXY(1,2);
        System.out.println(Arrays.toString(point.getXY()));
        point.setXY(3,4);
        System.out.println(point.toString());
        System.out.println("-----------");
        MoveablePoint mo=new MoveablePoint(3,4,5,6);
        System.out.println(mo.toString());
        mo.setSpeed(3,4);
        System.out.println(Arrays.toString(mo.getSpeed()));
        MoveablePoint mo1=new MoveablePoint(3,4,5,6);
        System.out.println(mo1.move());

    }
}
