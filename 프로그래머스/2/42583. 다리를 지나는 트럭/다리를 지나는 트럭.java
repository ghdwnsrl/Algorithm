import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
         Queue<Integer> queue = new LinkedList<>();
        int total_weight = 0;
        int answer = 0;

        for (int truck : truck_weights) {
            while (true) {
                // queue가 비었으면 일단 넣기
                if (queue.isEmpty()) {
                    total_weight += truck;
                    queue.offer(truck);
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) { // 길이가 긴 트럭을 빼줘야함
                    total_weight -= queue.poll();
                } else {
                    // 트럭을 더 추가할 수 없는 경우
                    if (total_weight + truck > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(truck);
                        total_weight += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}