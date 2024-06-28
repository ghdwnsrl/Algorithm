import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() && s.equals(')')) {
                return false;
            }

            if (!stack.empty() && stack.peek().equals('(') && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }

            stack.add(s.charAt(i));
        }

        return stack.isEmpty();

    }
}