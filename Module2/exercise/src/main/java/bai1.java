public class bai1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
