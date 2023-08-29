import java.util.Arrays;

public class demo4 {
    public static void main(String[] args) {
        int [] arr={1,1,2,3,4,5,6,7,5};
        int[] newArr=new int [arr.length];
        int k = 0;
        boolean isDuplicate;
        for (int i = 0; i < arr.length; i++) {
            isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newArr[k++] = arr[i];
            }
        }
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = newArr[i];
        }
        System.out.println("Mang sau khi xoa cac phan tu giong nhau:");
        System.out.println(Arrays.toString(newArr));

    }

}
