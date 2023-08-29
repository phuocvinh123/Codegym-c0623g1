import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int[] arr={4,7,9,11,12,13};
        Scanner input=new Scanner(System.in);
        System.out.println("nhập vị trí muốn xóa");
        int number=input.nextInt();
//        for(int i=0;i<arr.length;i++){
//            if(number==i){
//                arr[i]=0;
//            }
//        }
        arr[number]=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==0){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }System.out.println("vị trí "+number+" sau khi xóa mảng là:");
        for(int i = 0; i <arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
