package staticmethod;

public class TestStaticMethod {
    public static void main(String[] args) {
        StaticMethod.change();
        StaticMethod s1=new StaticMethod(111,"Hoang");
        StaticMethod s2=new StaticMethod(112,"Hà");
        StaticMethod s3=new StaticMethod(113,"Hải");
        s1.display();
        s2.display();
        s3.display();
    }
}
