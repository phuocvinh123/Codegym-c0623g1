import java.util.Scanner;

public class characterCount {
    public static void main(String[] args) {
        String arr = "Hello my friend";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ký tự muốn đếm trong chuỗi:");
        char character = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == character) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự " + character + " trong chuỗi là: " + count);
    }
}
