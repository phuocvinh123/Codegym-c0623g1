package bai8;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ManagerCard managerCard=new ManagerCard();
        while (true){
            System.out.println("book management library");
            System.out.println("Enter 1: To insert Loan Card");
            System.out.println("Enter 2: To search Loan card");
            System.out.println("Enter 3: To show information Loan card");
            System.out.println("Enter 4: To remove Loan card by id");
            System.out.println("Enter 5: To exit:");
            String line=scanner.nextLine();
            switch (line){
                case "1":{
                    System.out.println("To insert Loan Card:");
                    System.out.println("Enter name Student:");
                    String name =scanner.nextLine();
                    System.out.println("Enter age:");
                    int age=scanner.nextInt();
                    System.out.println("Enter class1:");
                    scanner.nextLine();
                    String class1=scanner.nextLine();
                    System.out.println("Enter id:");
                    String id=scanner.nextLine();
                    System.out.println("Enter borrowedDate:");
                    String borrowedDate=scanner.nextLine();
                    System.out.println("Enter DateDue:");
                    String dateDue=scanner.nextLine();
                    System.out.println("Enter number:");
                    int number=scanner.nextInt();
                    LoanCard loanCard=new LoanCard(name,age,class1,id,borrowedDate,dateDue,number);
                    managerCard.AddLoanCard(loanCard);
                    System.out.println(loanCard.toString());
                    scanner.nextLine();
                    break;
                }
                case "2":{
                    System.out.println("Enter a to search Loan Card");
                    String search=scanner.nextLine();
                    managerCard.searchLoanCard(search).forEach(loanCard -> System.out.println(loanCard.toString()));
                    break;
                }
                case "3":{
                    managerCard.showLoanCard();
                    break;
                }
                case "4":{
                    System.out.print("Enter id to remove: ");
                    String id=scanner.nextLine();
                    System.out.println(managerCard.delete(id) ? "Success" : "Fail");

                }
                break;
                case "5":{
                    return;
                }
                default:
                    System.out.println("Invaity");
                    continue;

            }
        }
    }
}
