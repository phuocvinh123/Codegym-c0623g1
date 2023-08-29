import java.util.Arrays;
import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 11, 12, 13};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vị trí muốn xóa:");
        int number = input.nextInt();
        for (int i = number; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        System.out.println("Mảng sau khi xóa phần tử tại vị trí " +number + ":");
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        }
    }


