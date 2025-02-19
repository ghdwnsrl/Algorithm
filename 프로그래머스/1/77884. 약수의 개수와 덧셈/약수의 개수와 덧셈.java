import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .map(i -> {
                    if (i % Math.sqrt(i) == 0)
                        return i * -1;
                    else
                        return  i;
                })
                .sum();
    
    }
}