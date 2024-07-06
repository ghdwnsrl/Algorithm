import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        List<Integer> list = new ArrayList<>();

        while(n / 10 != 0) {
            int tmp = (int) (n % 10);
            n = n / 10;
            list.add(tmp);
        }

        if (n > 0) {
            list.add((int)n);
        }

        
        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}