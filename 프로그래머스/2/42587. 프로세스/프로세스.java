import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new int[]{priorities[i], i});
        }
        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(pq.peek() > cur[0]) {
                queue.offer(cur);
            } else {
                if (location == cur[1]) {
                    break;
                }
                pq.poll();
                count++;
            }
        }
        
        return count;
    }
}