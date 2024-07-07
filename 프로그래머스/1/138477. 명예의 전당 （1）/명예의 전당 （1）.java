import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> queue = new PriorityQueue<>();
        int[] answer = new int[score.length];
        int idx = 0;

        for (int i = 0; i < score.length; i++) {

            if (queue.size() < k) {
                queue.add(score[i]);
                answer[idx++] = queue.peek();
                continue;
            }

            if (queue.peek() < score[i]) {
                queue.poll();
                queue.add(score[i]);
                answer[idx++] = queue.peek();
            } else {
                answer[idx++] = queue.peek();
            }

        }
        return answer;
    }
}