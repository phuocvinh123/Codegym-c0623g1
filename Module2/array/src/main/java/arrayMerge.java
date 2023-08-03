import java.util.Arrays;

public class arrayMerge {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
