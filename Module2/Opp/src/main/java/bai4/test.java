package bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Town town=new Town();
        System.out.println("Enter n:");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter Address");
            scanner.nextLine();
            String address=scanner.nextLine();
            List<Person>person=new ArrayList<>();
            System.out.println("Enter number person:");
            int number=scanner.nextInt();
            for(int j=0;j<number;j++){
            }
            town.addFamily(new Family(person,address));
        }
    }
}
