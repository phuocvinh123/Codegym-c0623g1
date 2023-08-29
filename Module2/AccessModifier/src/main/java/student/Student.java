package student;

public class Student {
    private String name;
    private String classes;

    public Student() {
        name="jonh";
        classes="C02";
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    void display(){
        System.out.println("name: "+name+",classes: "+classes);
    }

    public static void main(String[] args) {
        Student student1=new Student();
        student1.setName("adam");
        student1.setClasses("C06");
        student1.display();
        Student student2=new Student();
        student2.display();
    }
}
