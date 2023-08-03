import java.util.Scanner;

public class deleteArray {
    public static void main(String[] args) {
       int[]arr={1,2,3,4,5,6,7};
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập số muốn xóa");
        int number=scanner.nextInt();
        for(int i=0;i<arr.length;i++){
           int index=0;
            if(number==arr[i]){
                arr[i]=index;
            }
        }
        System.out.println(number+"sau khi xóa khỏi mảng là");
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                System.out.print(+arr[i]+" ");
            }
        }

    }
}
