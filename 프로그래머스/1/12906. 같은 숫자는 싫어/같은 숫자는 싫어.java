import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i ++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            
            if(stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        return stack.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}