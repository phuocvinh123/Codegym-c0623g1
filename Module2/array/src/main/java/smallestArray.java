public class smallestArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {9, 2, 34, 6, 7, 3},
                {9, 3, 4, 1, 2, 4},
        };
        int min=arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]<min){
                    min=arr[i][j];
                }
            }
        }
        System.out.println("smallest value in 2d array is:"+" "+min);
    }
}
