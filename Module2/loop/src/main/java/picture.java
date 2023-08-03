import java.util.Scanner;

public class picture {
    public static void main(String[] args) {
        int choice=-1;
        Scanner input=new Scanner(System.in);
        while (choice!=0){
            System.out.println("menu");
            System.out.println("Print the rectangle");
            System.out.println("Print the square top-left");
            System.out.println("Print the square top-right");
            System.out.println("Print the square botton-left");
            System.out.println("Print the square botton-left");
            System.out.println("Print isosceles triangle");
            System.out.println("0.exit");
            System.out.println("enter your choice");
            choice =input.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Print the rectangle");
                    for(int i=1;i<=3;i++){
                        for(int j=1;j<=7;j++){
                            System.out.print("*");
                        }System.out.println();
                    }break;
                case 2:
                    System.out.println("Print the square triangle top-left");
                    for(int i=1;i<=5;i++){
                        for(int j=1;j<i;j++){
                            System.out.print("*");
                        } System.out.println();
                    }break;
                case 3:
                    System.out.println("Print the square triangle top-right");
                    for(int i=7;i>=1;i--){
                        for(int j=1;j<=i;j++){
                            System.out.print("*");
                        } System.out.println("*");
                    }break;
                case 4:
                    System.out.println("Print the square triangle botton-left");
                    for (int i = 1; i <=5; i++) {
                        for (int k = 1; k <= 5; k++) {
                            System.out.print("");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }break;
                case 5:
                    System.out.println("Print the square triangle botton-right");
                    for (int i = 1; i <= 5; i++) {
                        for (int k = 5; k >= i; k--) {
                            System.out.print("*");
                        }
                        System.out.println();
                        for (int j = 1; j <= i; j++) {
                            System.out.print(" ");
                    }
                    }break;
                case 6:
                    System.out.println("Print isosceles triangle");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5 - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
