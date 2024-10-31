import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            Integer first = pq.poll();
            Integer second = pq.poll();
            Integer mix = first + second * 2;
            pq.add(mix);
            answer ++;
        }
        return answer;
    }
}