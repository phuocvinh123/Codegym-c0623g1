import java.util.Arrays;

public class baitap2 {
    public static void main(String[] args) {
//        Bài 1: Tính tổng các giá trị lớn hơn giá trị đứng liền trước nó trong mảng 1 chiều các số thực
//        int [] arr = {1,4,3,2,6,7,4,9};
//        int total=0;
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i+1]>arr[i]){
//                total+=arr[i];
//            }
//        }
//        System.out.println(total);
        //bài 2:Tính trung bình cộng các số dương trong mảng 1 chiều các số thực
//        int [] arr = {1,-4,3,-1,2,6,-7,4,9};
//       int total=0;
//       int count=0;
//       for(int i=0;i<arr.length;i++){
//           if(arr[i]>0){
//               total+=arr[i];
//               count++;
//           }
//       }if(count>0){
//           int avg=total/count;
//            System.out.println("trung bingf cộng các số dương trong mảng 1 chiều là"+avg);
//        }
        //bài 3:Đưa các số chia hết cho 3 về đầu mảng
//        int [] arr = {1,-4,3,-1,2,6,-7,4,9};
//        int j = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % 3 == 0) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                j++;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        //bài 4:Đảo ngược mảng ban đầu
//        int [] arr = {1,-4,3,-1,2,6,-7,4,9};
//        for(int i=0;i<arr.length/2;i++){
//            int temp=arr[i];
//            arr[i]=arr[arr.length-i-1];
//            arr[arr.length-i-1]=temp;
//        }
//        System.out.println(Arrays.toString(arr));
        //bài 5:Hãy liệt kê các số trong mảng 1 chiều các số thực thuộc đoạn [x, y] cho trước
//        int [] arr = {1,-4,3,-1,2,6,-7,4,9};
//        int x=-4,y=5;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>x&&arr[i]<y){
//                System.out.print(arr[i]+ " ");
//            }
//        }
//bài 6: Hãy liệt kê các giá trị trong mảng mà thỏa điều kiện lớn hơn giá trị tuyệt đối của giá trị đứng liền sau nó
//        int [] arr ={1,-4,3,-1,2,6,-7,9,4};
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i]>Math.abs(arr[i+1])){
//                System.out.print(arr[i]+" ");
//            }
//        }
        //bài 7:Hãy liệt kê các vị trí mà giá trị tại đó là số chính phương trong mảng 1 chiều các số nguyên
//        int [] arr ={1,4,3,-1,2,6,-7,9,4};
//        for(int i=0;i<arr.length;i++){
//            if(Math.sqrt(arr[i])==(int)(Math.sqrt(arr[i]))){
//                System.out.print(arr[i]+" ");
//            }
//        }
        //bài 8:Đếm số dương chia hết cho 7 trong mảng
//        int [] arr ={1,14,3,-1,2,6,-7,49,4};
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]%7==0){
//                System.out.print(arr[i]+" ");
//            }
//        }
        //bài9:Đếm số nguyên tố trong mảng
//        int [] arr = {1,4,3,2,6,7,4,9};
//        for(int i=0;i<arr.length;i++){
//            if(prime(arr[i])){
//                System.out.print(arr[i]+" ");
//            }
//        }
        //bài 10:Hãy xác định số lượng phần tử kề nhau mà cả 2 đều chẵn
//        int [] arr = {1,4,3,2,6,7,4,9};
//        int count=0;
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i]%2==0&&arr[i+1]%2==0){
//               count++;
//            }
//        } System.out.print(count+" ");
        //bài 11:Kiểm tra mảng có đối xứng không? Có trả về 1, không có trả về 0
//        int [] arr = {1,4,3,2,6,7,4,9};
//        for(int i=0,j=arr.length-1;i<arr.length/2;i++,j--){
//            if(arr[i]==arr[j])
//                System.out.print("1");
//            else
//                System.out.print("0");
//        }
        //bài 12:Kiểm tra mảng có tăng dần hay không
//        int [] arr = {1,2,3,4,6,7,8,9};
//        System.out.println(ascending(arr));
        //bài 13:Hãy cho biết tất cả các phần tử trong mảng a có nằm trong mảng b không
//        int [] arr = {1,2,3,4,6,7,8,9};
//        int [] arr1 = {1,2,3,4,5,7,8,9};
//        System.out.println(isSubarray(arr,arr1));
        //bài 14: Kiểm tra ma trận 2 chiều có toàn dương hay không
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        System.out.println(allYang(arr));
        //bài 15:Kiểm tra một cột ma trận có giảm dần hay không
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 8, 6},
//                {7, 5, 9}
//        };
//        System.out.println(checkReduceArr(arr,1));
        //bài 16:Kiểm tra ma trận có tồn tại số lẻ hay không
//        int[][] arr = {
//                {2, 2, 4},
//                {4, 2, 6},
//                {4, 2, 2}
//        };
//        System.out.println(containsOddNumber(arr));
        //bài 17:Liệt kê các dòng giảm dần trong ma trận
//        int[][] arr = {
//                {4, 2, 1},
//                {4, 2, 6},
//                {4, 2, 2}
//        };
//        decrease(arr);
        //Bài 18: Tìm số chẵn đầu tiên trong ma trận
//        int[][] arr = {
//                {5, 7, 1},
//                {3, 2, 6},
//                {4, 2, 2}
//        };
//        evenNumber(arr);

      //  Bài 19: Tìm số chẵn lớn nhất trong ma trận
//        int[][] arr = {
//                {5, 7, 1},
//                {3, 2, 6},
//                {4, 2, 2}
//        };
//        System.out.println(largestEvenNumber(arr));
        //bài 20:Liệt kê các dòng có tổng lớn nhất
        int[][] arr = {
                {5, 7, 1},
                {3, 2, 6},
                {4, 2, 2}
        };
        largestSum(arr);
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

    public static boolean ascending (int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

        public static boolean isSubarray(int[] a, int[] b) {
            for (int i = 0; i <= b.length - a.length; i++) {
                boolean found = true;
                for (int j = 0; j < a.length; j++) {
                    if (a[j] != b[i + j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
            return false;
        }

    public static boolean allYang(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]<=0){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkReduceArr(int[][] arr, int colum){
        if(colum >= arr.length || colum< 0)
            return  false;
        for(int j = 0; j<arr[colum].length-1;j++){
            if(arr[j][colum] > arr[j+1][colum]) return false;
            }
            return true;
        }

    public static boolean containsOddNumber(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]%2!=0){
                    return true;
                }
            }
        }return false;
    }

    public static void decrease(int[][] arr){
        for(int i=0;i<arr.length;i++){
            boolean good=true;
            for(int j=1;j<arr[i].length;j++){
                if(arr[i][j] > arr[i][j-1]){
                    good=false;
                    break;
            }
        }if(good){
                System.out.println("Row " + i + " is decreasing: " + Arrays.toString(arr[i]));
            }
    }
}

    public static void evenNumber(int[][] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]%2==0){
                    count++;
                    if(count==1){
                        System.out.println(arr[i][j]);
                    }
                }
            }
        }
    }

    public static int largestEvenNumber(int[][] arr){
        int max=arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]%2==0){
                    if(arr[i][j]>max){
                        max=arr[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static void largestSum(int[][] arr){
        int total=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                total+=arr[i][j];
            }
            System.out.print(total);
            }
    }
}

