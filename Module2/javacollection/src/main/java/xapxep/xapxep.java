package xapxep;

import java.util.Arrays;
import java.util.Scanner;

public class xapxep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi: ");
        String input = scanner.nextLine();

        // Chuyển đổi chuỗi thành mảng kí tự
        char[] charArray = input.toCharArray();

        // Sắp xếp mảng kí tự theo thứ tự từ bé đến lớn
        Arrays.sort(charArray);

        // Hiển thị chuỗi kí tự con đã sắp xếp
        String sortedString = new String(charArray);
        System.out.println("Chuỗi kí tự con đã sắp xếp: " + sortedString);
    }
}
