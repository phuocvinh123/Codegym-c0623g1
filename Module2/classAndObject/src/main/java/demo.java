import java.util.Arrays;
public class demo {
    public demo() {
    }

    public static void main(String[] args) {
        //Sắp xếp lẻ tăng dần nhưng giá trị khác giữ nguyên vị trí
//        int [] arr = {1,5,3,8,2,6,7,4,9};
//        int j = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % 2 != 0) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                j++;
//            }
//        }
//        System.out.println(Arrays.toString(arr));

      //  Sắp xếp số dương tăng dần, các số âm giữ nguyên vị trí
//        int [] arr = {1,5,-3,8,-1,2,6,7,-4,9};
//        for(int i=0;i<arr.length-1;i++){
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i]>0&&arr[j]>0){
//                    if(arr[i]>arr[j]){
//                        int temp =arr[i];
//                        arr[i]=arr[j];
//                        arr[j]=temp;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        //Bài 9: Sắp xếp số dương tăng dần, âm giảm dần. Vị trí tương đối không thay đổi
//        int [] arr = {7,-1,4,-6};       // {4,-6, 7, -1}
//        for(int i=0;i<arr.length-1;i++){
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i]>0&&arr[j]>0){
//                if(arr[i]>arr[j]){
//                    int temp=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=temp;
//                }
//            }
//                else if(arr[i]<0&&arr[j]<0){
//                    if(arr[i]<arr[j]){
//                        int temp=arr[i];
//                        arr[i]=arr[j];
//                        arr[j]=temp;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        int [] arr = {9,8,7,6,5,4,3,2,1};
        int [] arr1 = {5,2,1,4,5,4,6,3,1};
//        location(arr);        //bài1
//        checkPrime(arr);       //bài 2
//        countNumber(arr);       bài 3
         //bài 4:
//        if(checkZero(arr)){
//            System.out.println("1");
//        }else{
//        System.out.println("0");
//        }
//        System.out.println(descendingArray(arr));  //bài 5
//        System.out.println(compare(arr,arr1));    //bài 6
    }
    //Bài 1: Hãy liệt kê các giá trị có toàn chữ số lẻ trong mảng 1 chiều các số nguyên
    public static void location(int[] arr){

        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                System.out.print(arr[i]+" ");
            }
        }

    }
   // Bài 2: Hãy liệt kê các vị trí mà giá trị tại đó là số nguyên tố
    public static boolean prime(int number){
        if(number<2){
            return false;
        }
        for(int i=2;i<number;i++){
            if(number%2==0){
                return false;
            }
        }
        return true;
    }

    public static void checkPrime(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(prime(arr[i])){
                System.out.print(arr[i]+" ");
            }
        }
    }

//    Bài 3: Đếm số lượng giá trị tận cùng bằng 5 trong mảng
    public static void countNumber(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%10==5){
                System.out.print(arr[i]+" ");
            }
        }
    }
//    Bài 4: Kiểm tra mảng có giá trị 0 hay không? Có trả về 1, không có trả về 0
    public static boolean checkZero(int[] number){
        for(int i=0;i<number.length;i++){
            if(number[i]==0){
                return true;
            }
        }
        return false;
    }

//Bài 5: Kiểm tra mảng có giảm dần hay không
public static boolean descendingArray(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return true;
            }
        }
    return false;
}

//bài6: Hãy cho biết tất cả các phần tử trong mảng a có nằm trong mảng b không
public static boolean compare(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            boolean found=false;
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]){
                    return true;
                }
            }
            if(!found){
                return false;
            }
        }
    return false;
}
}
