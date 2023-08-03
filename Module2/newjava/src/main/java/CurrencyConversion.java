import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double dollars=23000;
        double vnd;
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the number");
         vnd=scanner.nextDouble();
         double convert=vnd*dollars;
        System.out.println("price là :"+" "+convert+" "+"vnđ");
    }
}
