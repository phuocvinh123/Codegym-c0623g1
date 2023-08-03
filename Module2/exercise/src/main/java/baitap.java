import java.util.Arrays;

public class baitap {
    public static void main(String[] args) {
        //bai1:tìm giá trị lớn nhất trong mảng
//        int[] arr={1,4,2,6,5};
//        int max = arr[0];
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//        }
//        System.out.println("giá trị lớn nhất trong mảng là"+max);
        //bài 2:tìm giá trị lớn thứ 2 trong mảng
//        int[] arr={1,4,7,6,5};
//        int max=arr[0];
//        int seccon=arr[1];
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//            else if(max>arr[i]&&seccon<arr[i]){
//                seccon=arr[i];
//            }
//        }
//        System.out.println(seccon);
        //bài 3:Tính tổng 3 giá trị lẻ đầu tiên
//        int[] arr={1,4,2,6,5,3,7,8};
//        int count=0;
//        int total=0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]%2!=0){
//                total+=arr[i];
//                count++;
//            } if(count==3){
//                System.out.println("tổng 3 số lẻ đầu tiên trong mảng là"+total);
//            }
//        }
        //bài 4:Đảo ngược mảng
//        int[] arr={1,4,2,6,5,3,7,8};
//        for(int i=0;i<arr.length/2;i++){
//            int temp=arr[i];
//            arr[i]=arr[arr.length-1-i];
//            arr[arr.length-1-i]=temp;
//        }
//        System.out.println(Arrays.toString(arr));
        //bài 5: nối mảng b vào mảng a
//        int[] arr1 = {1, 2, 3};
//        int[] arr2 = {4, 5, 6};
//        int[] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
//        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
//            System.out.print(Arrays.toString(result));
        //bài 6:tính tổng các số nguyên tố trong mảng
//        int[] arr={1,4,2,6,5,3,7,8};
//        int total=0;
//        int number=2;
//        for(int i=0;i<arr.length;i++){
//            if(prime(arr[i])){
//                total+=arr[i];
//            }
//        }System.out.println(total);
        //bài7:tính trung bình các số chính phương trong mảng
//       int[] arr = {1,4,3,2,6,7,4,9};
//       int count=0;
//      int sum=0;
//       for(int i=0;i<arr.length;i++){
//           if(arr[i] == Math.pow((int) Math.sqrt(arr[i]), 2)){
//              sum+=arr[i];
//               count++;
//           }
//       }if(count>0){
//            int avg=sum/count;
//            System.out.print(avg+ " ");
//        }else{
//            System.out.println("không có số chính phương trong mảng");
//        }
    //bài 8:hiển thị các cột chẵn
//        int[] arr = {1,4,3,2,6,7,4,9};
//        for(int i=0;i<arr.length;i++){
//            if(i%2==0){
//                System.out.print(arr[i]+" ");
//            }
//        }
        //bài 9:Tính tổng các giá trị đường viền
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//                 };
//        int total=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length;j++){
//                if(i==0||i==arr.length-1||j==0||j==arr[i].length-1){
//                    total+=arr[i][j];
//                }
//            }
//        }
//        System.out.println("tổng các giá trị đường viền là"+total);
        //bài 10:Tìm ra vị trí [i,j] của số chẳn đầu tiên
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int rowIndex = -1;
//        int colIndex = -1;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] % 2 == 0 && arr[i][j] > 0) {
//                    if (rowIndex == -1 && colIndex == -1) {
//                        rowIndex = i;
//                        colIndex = j;
//                    }
//                }
//            }
//        }
//        if (rowIndex != -1 && colIndex != -1) {
//            System.out.println("Vị trí số chẵn đầu tiên: hàng " + rowIndex + ", cột " + colIndex);
//        } else {
//            System.out.println("Không tìm thấy số chẵn lớn hơn 0 trong mảng");
//        }
        //bài 11:Tính tổng các số nguyên tố trong mảng 2 chiều
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int total=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length;j++){
//                if(prime(arr[i][j])){
//                    total+=arr[i][j];
//                }
//            }
//        }System.out.println("tổng số ngyên tố trong mảng 2 chiều là"+total);
// bài 12:Tính tổng: tam giác trên trái, trên phải, dưới trái, dưới phải
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

    }
    public static boolean prime(int number) {
        if(number<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
}
}
