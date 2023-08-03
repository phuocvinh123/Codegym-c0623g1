import java.util.Arrays;
import java.util.Scanner;

public class insertArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần chèn: ");
        int number = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn: ");
        int position = scanner.nextInt();

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        newArr[position] = number;
        for (int i = position + 1; i < newArr.length; i++) {
            newArr[i] = arr[i - 1];
        }
        System.out.println("Các phần tử của mảng sau khi chèn số " + number + " vào vị trí " + position + " là:");
        showArr(newArr);
    }
    public static void showArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
