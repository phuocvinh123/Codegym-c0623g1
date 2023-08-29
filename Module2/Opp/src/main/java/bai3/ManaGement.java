package bai3;

import java.util.ArrayList;
import java.util.List;

public class ManaGement {
    List<Student>students;

    public ManaGement() {
        this.students = new ArrayList<>();
    }
    public void AddStudent(Student student){
        this.students.add(student);}
    public void Show(){
        this.students.forEach(student -> System.out.println(student.toString()));
    }
    public void searchBlockA(){this.students.stream().filter(student -> student instanceof Block_A).forEach(student -> System.out.println(student.toString()));}
    public void searchBlockB(){this.students.stream().filter(student -> student instanceof Block_B).forEach(student -> System.out.println(student.toString()));}
    public void searchBlockC(){this.students.stream().filter(student -> student instanceof Block_C).forEach(student -> System.out.println(student.toString()));}

    public boolean delete(String id){
        Student stu= this.students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
        if(stu==null){
            return false;
        }
        this.students.remove(stu);
        return true;
    }
}
