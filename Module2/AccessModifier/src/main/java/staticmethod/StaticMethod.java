package staticmethod;

public class StaticMethod {
    private int rollno;
    private String name;
    private static String college="Khoa Học";

    StaticMethod(int r,String n) {
        rollno=r;
        name=n;
    }
    static void change(){
        college="CodeGym";
    }
    void display(){
        System.out.println(name+" "+rollno+" "+college);
    }
}
