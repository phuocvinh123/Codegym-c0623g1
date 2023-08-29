import java.util.Arrays;

public class bai2 {
    public static void main(String[] args) {
        int[] arr={4,7,9,11,12,13,17,20};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(!CheckNumber(arr[i])){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
    public static boolean CheckNumber(int number){
        if(number<=1){
            return false;
        }for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
