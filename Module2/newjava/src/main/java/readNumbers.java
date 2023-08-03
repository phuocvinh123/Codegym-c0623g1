import java.util.Scanner;

public class readNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=-1;
        while(number!=0){
        System.out.println("enter the number to read");
        number=scanner.nextInt();
        switch (number){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("for");
                break;
            case 5:
                System.out.println("fire");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            case 10:
                System.out.println("teen");
                break;
            default:
                System.out.println("out of ability");
                break;
        }
        }
    }
}
