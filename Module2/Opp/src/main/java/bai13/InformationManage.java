package bai13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InformationManage {
    List<Employee>employees;

    public InformationManage() {
        this.employees = new ArrayList<>();
    }
    public void addEmploy(Employee employee){this.employees.add(employee);}
    public void searchIntern(){
        this.employees.stream().filter(inter->inter instanceof Intern).forEach(inter-> System.out.println(inter.toString()));
    }
    public void searchFresher(){
        this.employees.stream().filter(fresher->fresher instanceof Fresher).forEach(fresher-> System.out.println(fresher.toString()));
    }
    public void searchExperience(){
        this.employees.stream().filter(experience->experience instanceof Experience).forEach(experience-> System.out.println(experience.toString()));
    }
    public boolean delete(String id){
        Employee emp=this.employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
        if(emp==null){
            return false;
        }
        this.employees.remove(emp);
        return true;
    }
    public void show(){
        this.employees.forEach(employee -> System.out.println(employee.toString()));
    }

//    public void Edit(String id){
//        Scanner scanner = new Scanner(System.in);
//       Employee edit=this.employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
//       if(edit!=null){
//           System.out.println("Enter id:");
//           id = scanner.nextLine();
//           System.out.println("Enter fullName:");
//           String name=scanner.nextLine();
//           System.out.println("Enter birthday");
//           LocalDate birthday = DateUtils.parseDate(scanner.nextLine());
//           System.out.println("Enter phone:");
//           String phone=scanner.nextLine();
//           System.out.println("Enter email:");
//           String mail=scanner.nextLine();
//           System.out.println("Enter employeeType");
//           int employ=scanner.nextInt();
//           scanner.nextLine();
//       }
//    }
}
