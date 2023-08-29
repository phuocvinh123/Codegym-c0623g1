package circleCylinder;

public class test {
    public static void main(String[] args) {
        Circle circle=new Circle();
         circle =new Circle("blue",3.5);
        System.out.println(circle.toString());
        System.out.println(circle.getCircleArea());
        System.out.println("----------");
        Cylinder cylinder=new Cylinder();
        cylinder=new Cylinder("red",5.5,3);
        System.out.println(cylinder.toString());
        System.out.println(cylinder.getCylinderArea());
    }
}
