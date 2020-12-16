import java.util.ArrayList;
import java.util.Stack;

public class Homework14 {
    public static void main(String args[]) {
        System.out.println(parentheses("(){sd[ cvcvd]} dfcv "));
    }

    public static boolean parentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (isParentheses(current)) {
                if (!stack.isEmpty()) {
                    if ((current == ')' && stack.peek() == '(') || (current == '}' && stack.peek() == '{') || (current == ']' && stack.peek() == '[')) {
                        stack.pop();
                    } else {
                        stack.push(current);
                    }
                } else {
                    stack.push(current);
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isParentheses(char c) {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('(');
        arrayList.add(')');
        arrayList.add('[');
        arrayList.add(']');
        arrayList.add('{');
        arrayList.add('}');
        return arrayList.contains(c);
    }
}