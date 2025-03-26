import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - i - 1;
            int[] curP = new int[]{i, prices[i]};
            while(!stack.isEmpty() && curP[1] < stack.peek()[1]) {
                int[] p = stack.pop();
                answer[p[0]] = i - p[0];
            }
            stack.push(curP);
        }
        return answer;
    }
}