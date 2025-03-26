import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int total_weight = 0;
        int answer = 0;
        int truckIdx = 0;

        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        while (truckIdx < truck_weights.length) {
            answer++;
            total_weight -= queue.poll();
            if ( weight >= total_weight + truck_weights[truckIdx]) {
                // 트럭이 지나갈 수 있다!
                queue.offer(truck_weights[truckIdx]);
                total_weight += truck_weights[truckIdx];
                truckIdx++;
            } else { // 지나갈 수 없다!
                queue.offer(0);
            }
    
        }
        return answer + bridge_length;
    }
}