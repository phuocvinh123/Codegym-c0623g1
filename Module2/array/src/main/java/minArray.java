public class minArray {
    public static void main(String[] args) {
        int [] arr={1,2,3,6,7,4};
      int index=minvalue(arr);
        System.out.println("min array is:"+" "+arr[index]);
    }

    public static int minvalue(int []array){
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<array[index]){
                index=i;
            }
        }
        return index;
    }
}
