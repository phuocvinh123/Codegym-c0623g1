public class demo3 {
    public static void main(String[] args) {
        //Bài 12: Xóa tất cả các số âm trong mảng
        int[] arr={1,2,3,-2,-6,7,8};
//        removeNegativeNumbers(arr);
//        removeEvenNumbers(arr);
    }
  public static void removeNegativeNumbers(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                System.out.print(arr[i]+" ");
            }
        }
  }

//    Bài 13: Xóa tất cả các số chẵn trong mảng
public static void  removeEvenNumbers(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                System.out.print(arr[i]+" ");
            }
        }
}

// Bài 14: Xóa tất cả các phần tử trùng nhau trong mảng và chỉ giữ lại duy nhất 1 phần tử

}
