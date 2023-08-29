package reverse;

import java.util.Stack;

public class reverseStack {
    public static int[] reverseArray(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int[]reverseArr=new int[arr.length];
        for(int num:arr){
            stack.push(num);
        }
        for(int i=0;i<arr.length;i++){
            reverseArr[i]=stack.pop();
        }
        return reverseArr;
    }

    public static void main(String[] args) {
        int[]number={1,2,3,4,5};
        int[]reverseNumbers=reverseArray(number);
        for(int num:reverseNumbers){
            System.out.println(num+" ");
        }
    }
}
