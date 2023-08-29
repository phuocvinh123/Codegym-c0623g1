import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[]arr={1,5,2,3,9,6,7};
        int pos, x;
        for(int i = 1; i < arr.length; i++){ //đoạn array[0] đã sắp xếp
            x = arr[i];
            pos = i;
            while(pos > 0 && x < arr[pos-1]){
                arr[pos] = arr[pos-1]; // đổi chỗ
                pos--;
            }
            arr[pos] = x;
        }
        System.out.println(Arrays.toString(arr));
    }
}
