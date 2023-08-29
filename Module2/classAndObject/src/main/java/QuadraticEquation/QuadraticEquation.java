package QuadraticEquation;

import java.util.Scanner;

public class QuadraticEquation {
    protected double a;
    protected double b;
    protected double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solveEquation() {
        double delta=b*b-4*a*c;
        if(delta>0){
            double x1=(-b+Math.sqrt(delta))/(2*a);
            double x2=(-b-Math.sqrt(delta))/(2*a);
            System.out.println("phương trình có 2 nghiệm phân biệt :");
            System.out.println("x1= "+x1);
            System.out.println("x2= "+x2);
        }else if (delta==0){
            double x=-b/(2*a);
            System.out.println("phương trình có nghiệm kép :");
            System.out.println("x= "+x);
        }else{
            System.out.println("phương trình vô nghiệm");
        }
    }

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("nhập số a");
        double a=input.nextDouble();
        System.out.println("nhập số b");
        double b=input.nextDouble();
        System.out.println("nhập số c");
        double c=input.nextDouble();

        System.out.println("ngiệm của phương trình bậc 2 là:");
        QuadraticEquation equation=new QuadraticEquation(a,b,c);
        equation.solveEquation();
    }
}
