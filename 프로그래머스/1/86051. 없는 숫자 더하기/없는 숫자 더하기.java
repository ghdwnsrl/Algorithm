import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> cmp = List.of(0,1,2,3,4,5,6,7,8,9);
        int answer = Arrays.stream(numbers)
            .filter(cmp::contains)
            .sum();
        answer = 45 - answer;
        return answer;
    }
}