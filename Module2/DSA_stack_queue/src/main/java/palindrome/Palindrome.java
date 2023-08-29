package palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Đọc từng ký tự của chuỗi và đưa vào stack và queue
        for (char ch : cleanedStr.toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }

        // So sánh từng cặp ký tự trong stack và queue
        while (!stack.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.remove();

            if (stackChar != queueChar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal, Panama";
        System.out.println(isPalindrome(str1));  // Kết quả: true

        String str2 = "Hello, World!";
        System.out.println(isPalindrome(str2));  // Kết quả: false
    }
}

