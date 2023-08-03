import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        int size;
      Scanner scanner=new Scanner(System.in);
        System.out.println("enter number");
        size=scanner.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.println("enter number"+i+" :");
            arr[i]=scanner.nextInt();
            System.out.println("enter number"+i+" :"+arr[i]);
        }
        for(int i=0;i<size;i++){
            System.out.println("phần tử thứ "+i+":"+arr[i]);

        }reverses(arr);
    }

    public static void reverses (int[]arr){
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
