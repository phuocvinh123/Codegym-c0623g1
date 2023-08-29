package binarynumber;

import java.util.Scanner;
import java.util.Stack;

public class BinaryNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Stack<Integer>stackSoDu=new Stack<Integer>();
        while (true){
            System.out.println("Menu");
            System.out.println("Enter 1:để nhập số muốn chuyển đổi");
            System.out.println("Enter 2:to exit");
            String line=scanner.nextLine();
            switch (line){
                case "1":{
                    System.out.println("Nhập số muốn chuyển đổi thập phân sang nhị phân");
                    int x=scanner.nextInt();
                    while (x>0){
                        int SoDu=x%2;
                        stackSoDu.push(SoDu);
                        x=x/2;
                    }
                    System.out.println("số nhị phân là:");
                    int n=stackSoDu.size();
                    for(int i=0;i<n;i++){
                        System.out.print(stackSoDu.pop());
                }
            }
                break;
                case "2":{
                    return;
                }
                default:
                    System.out.println("Invaity");
                    continue;
        }
        }
    }
}
