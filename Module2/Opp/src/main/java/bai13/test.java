package bai13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        InformationManage informationManage=new InformationManage();
        List<Certificate> certificatesExperience = new ArrayList<>();
        certificatesExperience.add(new Certificate(1L, "BAP TOT NGHIEP DAI HOC KHOA HOC", "GIOI", LocalDate.of(2022, 10, 10)));
        certificatesExperience.add(new Certificate(2L, "BAP TIENG ANH", "GIOI", LocalDate.of(2028, 10, 10)));
        Employee eplExperience = new Experience("1","quang đăng",LocalDate.of(2023,12,07),"0702503245","doan@gmail.com",0,2,"leader");
        eplExperience.setCertificates(certificatesExperience);
        informationManage.addEmploy(eplExperience);
        Employee.employeeCount = Employee.employeeCount + 1;
        while (true){
            System.out.println("List of employee");
            System.out.println("Enter 1: to insert");
            System.out.println("Enter 2:to search");
            System.out.println("Enter 3:to show");
            System.out.println("Enter 4: to delete");
            System.out.println("Enter 5:to edit");
            System.out.println("Enter 6:to exit");
            String line =scanner.nextLine();
            switch (line){
                case "1":{
                    System.out.println("Enter a: to insert Intern");
                    System.out.println("Enter b: to insert Fresher");
                    System.out.println("Enter c: to insert Experience");
                    String character=scanner.nextLine();
                    switch (character){
                        case "a":{
                            System.out.println("Enter id:");
                            String id=scanner.nextLine();
                            System.out.println("Enter fullName:");
                            String name=scanner.nextLine();
                            System.out.println("Enter birthday");
                            LocalDate birthday = DateUtils.parseDate(scanner.nextLine());
                            System.out.println("Enter phone:");
                            String phone=scanner.nextLine();
                            System.out.println("Enter email:");
                            String mail=scanner.nextLine();
                            System.out.println("Enter employeeType");
                            int employ=scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter Majors");
                            String majors=scanner.nextLine();
                            System.out.println("Enter Semester");
                            String semester=scanner.nextLine();
                            System.out.println("Enter University_name");
                            String uni=scanner.nextLine();
                            Employee inter=new Intern(id,name,birthday,phone,mail,employ,majors,semester,uni);
                            informationManage.addEmploy(inter);
                            System.out.println(inter.toString());
                            break;
                        }
                        case "b":{
                            System.out.println("Enter id:");
                            String id=scanner.nextLine();
                            System.out.println("Enter fullName:");
                            String name=scanner.nextLine();
                            System.out.println("Enter birthday");
                            LocalDate birthday = DateUtils.parseDate(scanner.nextLine());
                            System.out.println("Enter phone:");
                            String phone=scanner.nextLine();
                            System.out.println("Enter email:");
                            String mail=scanner.nextLine();
                            System.out.println("Enter employeeType");
                            int employ=scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter graduationDate");
                            LocalDate graduation = DateUtils.parseDate(scanner.nextLine());
                            System.out.println("Enter graduationRank");
                            String rank=scanner.nextLine();
                            System.out.println("Enter education");
                            String education=scanner.nextLine();
                            Employee fresher=new Fresher(id,name,birthday,phone,mail,employ,graduation,rank,education);
                            informationManage.addEmploy(fresher);
                            System.out.println(fresher.toString());
                            break;
                        }
                        case "c":{
                            System.out.println("Enter id:");
                            String id=scanner.nextLine();
                            System.out.println("Enter fullName:");
                            String name=scanner.nextLine();
                            System.out.println("Enter birthday");
                            LocalDate birthday = DateUtils.parseDate(scanner.nextLine());
                            System.out.println("Enter phone:");
                            String phone=scanner.nextLine();
                            System.out.println("Enter email:");
                            String mail=scanner.nextLine();
                            System.out.println("Enter employeeType");
                            int employ=scanner.nextInt();
                            System.out.println("Enter expInYear");
                            int exp=scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter proSkill");
                            String pro=scanner.nextLine();
                            Employee experience=new Experience(id,name,birthday,phone,mail,employ,exp,pro);
                            informationManage.addEmploy(experience);
                            System.out.println(experience.toString());
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "2":{
                    System.out.println("Enter a: to search intern");
                    System.out.println("Enter b: to search fresher");
                    System.out.println("Enter c: to search experience");
                    String choise=scanner.nextLine();
                    switch (choise){
                        case "a":{
                            informationManage.searchIntern();
                            break;
                        }
                        case "b":{
                            informationManage.searchFresher();
                            break;
                        }
                        case "c":{
                            informationManage.searchExperience();
                            break;
                        }
                        default:break;
                    }
                    break;
                }
                case "3":{
                    informationManage.show();
                    break;
                }
                case "4":{
                    System.out.print("Enter id to remove: ");
                    String id = scanner.nextLine();
                    System.out.println(informationManage.delete(id) ? "Success" : "Fail");
                    break;
                }
                case "5":{
                    System.out.println("Enter id to edit");
                }
                break;
                case "6":{
                    return;
                }
                default:
                    System.out.println("invaity");
                    continue;
            }
        }
    }
    }

