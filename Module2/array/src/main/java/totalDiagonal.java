import java.util.Scanner;

public class totalDiagonal {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {9, 2, 34},
                {9, 3, 4},
        };
        int total=0;
        int total2=0;
        for(int i=0;i<arr.length;i++){
                total+=arr[i][i];
                total2+=arr[i][arr.length-i-1];
        }
        System.out.println("tổng số đường chéo đầu là"+total);
        System.out.println("tổng số đường chéo thứ 2 là"+total2);
    }
}
