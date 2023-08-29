import java.util.Arrays;

public class Bai1 {
    public static void main(String[] args) {
        int[] arr={3,2,4,6,7, 9, 12};
        int[] newArr=new int[arr.length];
        int count=0;
        for(int i=0;i<arr.length;i++){
                if(!CheckNumber(arr[i])){
                    newArr[count]=arr[i];
                    count++;
                }
        }
        int[] arr1=new int[count];
        for(int i=0;i<count;i++){
            arr1[i]=newArr[i];
        }
        for(int j=0;j<arr1.length;j++){
            System.out.print(arr1[j]+" ");
        }
    }
    public static boolean CheckNumber(int number){
        if(number<2){
            return false;
        }
        else{
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        }
        return true;
    }
}
