package parentheseschecker;

import java.util.Stack;

public class ParenthesesChecker {
    public static boolean isParenthesesValid(String str) {
        Stack<Character> bStack = new Stack<>();

        for (char sym : str.toCharArray()) {
            if (sym == '(' || sym == '[' || sym == '{') {
                bStack.push(sym);
            } else if (sym == ')' || sym == ']' || sym == '}') {
                if (bStack.isEmpty()) {
                    return false;
                }

                char left = bStack.pop();
                if ((sym == ')' && left != '(') ||
                        (sym == ']' && left != '[') ||
                        (sym == '}' && left != '{')) {
                    return false;
                }
            }
        }

        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "(a + b) * [c - {d / e}]";
        System.out.println(isParenthesesValid(str1));  // Kết quả: true

        String str2 = "((a + b) * [c - {d / e})]";
        System.out.println(isParenthesesValid(str2));  // Kết quả: false
    }
}
