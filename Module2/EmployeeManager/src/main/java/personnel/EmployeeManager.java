package personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static personnel.GetValue.*;

public class EmployeeManager {
     ArrayList<Staff> staffs;

     public EmployeeManager(){this.staffs=new ArrayList<>();}
    public void addStaff(Staff staff){
        this.staffs.add(staff);
    }

    public void addStaffServe(){
        EmployeeManager ept=new EmployeeManager();
        Staff serve = new StaffServe();
        Staff.input(serve);
        ept.addStaff(serve);
        serve.showInfor();
    }
   public void addServingFood(){
       EmployeeManager ept=new EmployeeManager();
       Staff serving = new StaffServingFood();
       Staff.input(serving);
       ept.addStaff(serving);
       serving.showInfor();
   }
    public void addReceptionist(){
        EmployeeManager ept=new EmployeeManager();
        Staff reception = new StaffReceptionist();
        Staff.input(reception);
        ept.addStaff(reception);
        reception.showInfor();
    }
    public void addRegional(){
        EmployeeManager ept=new EmployeeManager();
        Staff regional = new RegionalChief();
        Staff.input(regional);
        ept.addStaff(regional);
        regional.showInfor();
    }
    public void addManage(){
        EmployeeManager ept=new EmployeeManager();
        Staff manage = new Manage();
        Staff.input(manage);
        ept.addStaff(manage);
        manage.showInfor();
    }
    public void show(){
   this.staffs.forEach(Staff::showInfor);
    }
    public void ShowStaffServe(){
    this.staffs.stream().filter(o ->o instanceof StaffServe ).forEach(Staff::showInfor);
    }
    public void ShowServingFood(){
        this.staffs.stream().filter(o ->o instanceof StaffServingFood ).forEach(Staff::showInfor);
    }
    public void ShowStaffReception(){
        this.staffs.stream().filter(o ->o instanceof StaffReceptionist ).forEach(Staff::showInfor);
    }
    public void ShowSRegional(){
        this.staffs.stream().filter(o ->o instanceof RegionalChief ).forEach(Staff::showInfor);
    }
    public void ShowManage(){
        this.staffs.stream().filter(o ->o instanceof Manage ).forEach(Staff::showInfor);
    }
public List<Staff>searchByNameStaff(String name){
return this.staffs.stream().filter(o->o.getFullName().contains(name)).collect(Collectors.toList());
}
public boolean delete(String name){
         Staff s=this.staffs.stream().filter(staff -> staff.getFullName().equals(name)).findFirst().orElse(null);
         if(s==null){
         return false;
         }
         this.staffs.remove(s);
         return true;
}
//public void edit(String name){
//    this.staffs.stream().filter(o -> o.getFullName().equals(name)).map(u->{
//       u.setFullName(name.getFullName)
//    });
//}
}
