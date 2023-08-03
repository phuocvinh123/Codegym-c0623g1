public class maximumArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {9, 2, 34, 6, 7, 3},
                {9, 3, 4, 1, 2, 4},
        };
        int max=arr[0][0];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    if(arr[i][j]>max){
                        max=arr[i][j];
                    }
                }
            }
        System.out.println("maximum value in 2 dimensional array is:"+" "+max);
    }
}
