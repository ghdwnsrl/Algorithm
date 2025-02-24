import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int i = 1; i <= order.length; i++) {
            if (order[idx] != i) {
                while (!stack.isEmpty() && order[idx] == stack.peek()) {
                    stack.pop();
                    idx ++;
                }
                stack.push(i);
            }
            else {
                idx ++;
                while (!stack.isEmpty() && order[idx] == stack.peek()) {
                    stack.pop();
                    idx ++;
                }
            }
        }
        return idx;
    }
}