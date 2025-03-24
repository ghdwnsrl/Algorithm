import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int day = 0;
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : days) {
            queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= cur) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        
        return list.stream()
                .mapToInt(i->i)
                .toArray();
    }
}