import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        //bài 11:Bài 11: Thêm x vào trong mảng tăng nhưng vẫn giữ nguyên tính tăng của mảng
        int [] arr = {5,2,1,4};
        Scanner input=new Scanner(System.in);
        System.out.println("nhập số muốn chèn");
        int number=input.nextInt();
        System.out.println("nhập vị trí muốn chèn");
        int location=input.nextInt();
        int[] newArr=new int[arr.length+1];
        for(int i=0;i<location;i++){
            newArr[i]=arr[i];
        }
        newArr[location]=number;
        for(int i=location+1;i<newArr.length;i++){
            newArr[i]=arr[i-1];
        }
        ascending(newArr);
    }
    public static void ascending(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}


