import java.util.Scanner;

public class totalArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {9, 2, 34, 6, 7, 3},
                {9, 3, 4, 1, 2, 4},
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vị trí cột muốn tính");
        int number = scanner.nextInt();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i][number];
        }
        System.out.println("tổng các phần tử trong cột thứ"+" "+number+"là: " + " "+total);
    }
}
