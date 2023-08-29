package bai4;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ProductManager productManager=new ProductManager();
        while (true){
            System.out.println("Menu");
            System.out.println("Enter 1:To insert");
            System.out.println("Enter 2:To search");
            System.out.println("Enter 3:To show");
            System.out.println("Enter 4:To delete");
            System.out.println("Enter 5:To exit");
            String line=scanner.nextLine();
            switch (line){
                case "1":{
                    System.out.println("Enter nameProduct");
                    String name=scanner.nextLine();
                    System.out.println("Enter quantity");
                    int qua=scanner.nextInt();
                    System.out.println("Enter price");
                    double price=scanner.nextDouble();
                    Product product=new Product(name,qua,price);
                    productManager.addProduct(product);
                    System.out.println(product.toString());
                    scanner.nextLine();
                    break;}
                case "2":{
                    System.out.println("Enter to name product");
                    String name=scanner.nextLine();
                    productManager.search(name).forEach(product1 -> System.out.println(product1.toString()));
                    break;
            }
                case "3":{
                    productManager.show();
                    break;
                }
                case "4":{
                    System.out.print("Enter name product to remove: ");
                    String id = scanner.nextLine();
                    System.out.println(productManager.delete(id) ? "Success" : "Fail");

                }
                break;
                case "5":{
                    return;
                }
                default:
                    System.out.println("invaity");
                    continue;
            }
        }
    }
}
