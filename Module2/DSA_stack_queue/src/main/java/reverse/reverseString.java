package reverse;

import java.util.Stack;

public class reverseString {
    public static String reverseString1(String str){
        Stack<Character> stack = new Stack<>();
        // Đẩy các ký tự của chuỗi vào Stack
        for (char ch : str.toCharArray()) {
                    stack.push(ch);
                }

                StringBuilder reversedStr = new StringBuilder();

                // Lấy ký tự từ Stack và ghép vào chuỗi mới đã đảo ngược
                while (!stack.isEmpty()) {
                    reversedStr.append(stack.pop());
                }

                return reversedStr.toString();
            }

    public static void main(String[] args) {
        String input="hello, world!";
        String reverseString1=reverseString1(input);
        System.out.println(reverseString1);
    }
        }

