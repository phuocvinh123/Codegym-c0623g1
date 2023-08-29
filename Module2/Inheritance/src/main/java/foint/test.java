package foint;

public class test {
    public static void main(String[] args) {
        Foint2D foint2d=new Foint2D();
        foint2d=new Foint2D(2,3);
        System.out.println(foint2d.toString());
        System.out.println("--------------");
        Foint3D foind3d=new Foint3D();
        foind3d=new Foint3D(3,4,5);
        System.out.println(foind3d.toString());
    }
}
