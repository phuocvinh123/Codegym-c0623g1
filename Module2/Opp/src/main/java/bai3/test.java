package bai3;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ManaGement manaGement=new ManaGement();
        while (true){
            System.out.println("student list");
            System.out.println("Enter 1:To insert");
            System.out.println("Enter 2:To search");
            System.out.println("Enter 3:To Show");
            System.out.println("Enter 4:To delete");
            System.out.println("Enter 5:To Exit");
            String line=scanner.nextLine();
            switch (line){
                case "1":{
                    System.out.println("Enter a:insert block_A");
                    System.out.println("Enter b:insert block_B");
                    System.out.println("Enter c:insert block_C");
                    String choise=scanner.nextLine();
                    switch (choise){
                        case "a":{
                            System.out.println("Enter id");
                            String id=scanner.nextLine();
                            System.out.println("Enter fullName");
                            String name=scanner.nextLine();
                            System.out.println("Enter Address");
                            String address=scanner.nextLine();
                            System.out.println("Enter priority");
                            String pri=scanner.nextLine();
                            System.out.println("Enter point maths");
                            int mat=scanner.nextInt();
                            System.out.println("Enter point physical");
                            int phy=scanner.nextInt();
                            System.out.println("Enter point chemistry");
                            int chem=scanner.nextInt();
                            Student block_a=new Block_A(id,name,address,pri,mat,phy,chem);
                            manaGement.AddStudent(block_a);
                            System.out.println(block_a.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "b":{
                            System.out.println("Enter id");
                            String id=scanner.nextLine();
                            System.out.println("Enter fullName");
                            String name=scanner.nextLine();
                            System.out.println("Enter Address");
                            String address=scanner.nextLine();
                            System.out.println("Enter priority");
                            String pri=scanner.nextLine();
                            System.out.println("Enter point maths");
                            int mat=scanner.nextInt();
                            System.out.println("Enter point chemistry");
                            int chem=scanner.nextInt();
                            System.out.println("Enter point biology");
                            int bio=scanner.nextInt();
                            Student block_b=new Block_B(id,name,address,pri,mat,chem,bio);
                            manaGement.AddStudent(block_b);
                            System.out.println(block_b.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c":{
                            System.out.println("Enter id");
                            String id=scanner.nextLine();
                            System.out.println("Enter fullName");
                            String name=scanner.nextLine();
                            System.out.println("Enter Address");
                            String address=scanner.nextLine();
                            System.out.println("Enter priority");
                            String pri=scanner.nextLine();
                            System.out.println("Enter point literature");
                            int lite=scanner.nextInt();
                            System.out.println("Enter point history");
                            int history=scanner.nextInt();
                            System.out.println("Enter point geography");
                            int geo=scanner.nextInt();
                            Student block_c=new Block_C(id,name,address,pri,lite,history,geo);
                            manaGement.AddStudent(block_c);
                            System.out.println(block_c.toString());
                            scanner.nextLine();
                            break;
                        }
                        default:break;
                    }
                    break;
                }
                case "2":{
                    System.out.println("Enter a search Block_A");
                    System.out.println("Enter b search Block_B");
                    System.out.println("Enter c search Block_C");
                    String character=scanner.nextLine();
                    switch (character){
                        case "a":{
                            manaGement.searchBlockA();
                            break;
                        }
                        case "b":{
                            manaGement.searchBlockB();
                            break;
                        }
                        case "c":{
                            manaGement.searchBlockC();
                            break;
                        }
                        default:break;
                    }
                    break;
                }
                case "3":{
                    manaGement.Show();
                    break;
                }
                case "4":{
                    System.out.println("Enter id to remove");
                    String id=scanner.nextLine();
                    System.out.println(manaGement.delete(id) ? "Success" : "Fail");
                }
                break;
                case "5":{
                    return;
                }
                default:
                    System.out.println("invality");
                    continue;
            }
        }
    }
}
