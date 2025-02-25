import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int[] array = Arrays.stream(d)
                .sorted()
                .toArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (budget < 0) break;
            budget -= array[i];
            count++;
        }        
        return budget >= 0 ? count : count - 1;
    }
}