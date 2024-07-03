import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        Queue<Integer> queue = new LinkedList();

        for (int s : section) {
            queue.add(s);
        }

        int count = 0;
        int idx = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() < idx) {
                queue.poll();
                continue;
            }
            idx = queue.poll() + m;
            count++;
        }
        return count;
    }
}