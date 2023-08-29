import java.util.Arrays;

public class demo5 {
    public static void main(String[] args) {
        //Bài 15: Hãy tất cả các số 1 về đầu mảng
        int [] arr={1,2,3,4,5,7,1,2,1,2};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]!=1&&arr[j]==1){
                int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}
