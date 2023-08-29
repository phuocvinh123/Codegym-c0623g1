import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
//        Bài 10: Thêm 1 phần tử x vào mảng tại vị trí k
        int [] arr = {5,2,1,4};
        Scanner input=new Scanner(System.in);
        System.out.println("nhập số muốn thêm vào mảng");
        int number=input.nextInt();
        System.out.println("nhập vị trí số muồn thêm vào mảng");
        int location=input.nextInt();
        int[] newArr=new int[arr.length+1];
        for(int i=0;i<location;i++){
            newArr[i]=arr[i];
        }
        newArr[location]=number;
        for(int i=location+1;i<newArr.length;i++){
        newArr[i]=arr[i-1];

}
        System.out.println("các phần tử của mảng sau khi chèn số "+number+" vào vị trí thứ "+location+" là");
        showArr(newArr);
    }
    public static void showArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
