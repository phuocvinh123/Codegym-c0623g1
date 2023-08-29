package bai2;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ManagerDocument managerDocument=new ManagerDocument();
        while (true){
            System.out.println("Application Manager Document");
            System.out.println("Enter 1: To insert document");
            System.out.println("Enter 2: To search document by category: ");
            System.out.println("Enter 3: To show information documents");
            System.out.println("Enter 4: To remove document by id");
            System.out.println("Enter 5: To exit:");
            String line = scanner.nextLine();
            switch (line){
                case "1":{
                    System.out.println("Enter a: to insert Book");
                    System.out.println("Enter b: to insert Newspaper");
                    System.out.println("Enter c: to insert Journal");
                    String type = scanner.nextLine();
                    switch (type){
                        case "a":{
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter nxb:");
                            String nxb = scanner.nextLine();
                            System.out.print("Enter number: ");
                            int number = scanner.nextInt();
                            System.out.print("Enter author: ");
                            scanner.nextLine();
                            String author = scanner.nextLine();
                            System.out.print("Enter page number: ");
                            int pageNumber = scanner.nextInt();
                            Document book = new Book(id, nxb, number, author, pageNumber);
                            managerDocument.addDocument(book);
                            System.out.println(book.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "b":{
                            System.out.println("Enter ID:");
                            String id=scanner.nextLine();
                            System.out.println("Enter nxb: ");
                            String nxb=scanner.nextLine();
                            System.out.println("Enter number:");
                            int number=scanner.nextInt();
                            System.out.println("Enter day Issue");
                            int dayIssue=scanner.nextInt();
                            Document newspape=new Newspape(id,nxb,number,dayIssue);
                            managerDocument.addDocument(newspape);
                            System.out.println(newspape.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c":{
                            System.out.println("Enter ID:");
                            String id=scanner.nextLine();
                            System.out.println("Enter nxb: ");
                            String nxb=scanner.nextLine();
                            System.out.println("Enter number:");
                            int number=scanner.nextInt();
                            System.out.println("Enter issue Number");
                            int issueNumber=scanner.nextInt();
                            System.out.println("Enter month Issue");
                            int monthIssue=scanner.nextInt();
                            Document journal=new Journal(id,nxb,number,issueNumber,monthIssue);
                            managerDocument.addDocument(journal);
                            System.out.println(journal.toString());
                            scanner.nextLine();
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "2":{
                    System.out.println("Enter a to search book");
                    System.out.println("Enter b to search newspaper");
                    System.out.println("Enter c to search journal");
                    String choise = scanner.nextLine();
                    switch (choise) {
                        case "a":{
                            managerDocument.searchByBook();
                            break;
                        }
                        case "b":{
                            managerDocument.searchByNewspaper();
                            break;
                        }
                        case "c":{
                            managerDocument.searchByJournal();
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "3":{
                    managerDocument.showInfor();
                    break;
                }
                case "4":{
                    System.out.print("Enter id to remove: ");
                    String id = scanner.nextLine();
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
