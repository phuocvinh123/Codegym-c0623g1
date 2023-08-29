package stopwatch;

import java.util.Date;

public class StopWatch {
    private  long  startTime;
    private  long endTime;

    public StopWatch(){
        this.startTime=System.currentTimeMillis();
    }
    public void start(){
        this.startTime=System.currentTimeMillis();
    }
    public void stop(){
        this.endTime=System.currentTimeMillis();
    }
    public  long getElapsedTime(){
        return this.endTime-this.startTime;
    }
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        ArrayUtils arrayUtils = new ArrayUtils();
        sw.start();

        int [] arr = arrayUtils.createArray(10000, 10000, 10);
        arrayUtils.interchangeSort(arr);
        sw.stop();

        System.out.println("Sort trong vong " + sw.getElapsedTime());
    }


    public static class ArrayUtils {

        public  int [] createArray(int size, int MAX, int MIN){
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) Math.floor(Math.random()*(MAX-MIN + 1) + MIN);
            }

            return arr;
        }

        public void interchangeSort(int [] numbers){
            for(int i= 0 ; i<numbers.length-1;i++){
                for (int j = i + 1; j < numbers.length; j++) {
//                    System.out.printf("i %s - j%s \n", i, j);
                    if(numbers[i] > numbers[j]){
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }
        }
}
}
