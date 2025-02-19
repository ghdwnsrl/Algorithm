import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .map(i -> {
                    int count = 0;
                    double sqrt = Math.sqrt(i);
                    for (int j = 1; j <= sqrt; j++) {
                        if (i % j == 0) {
                            count++;
                            if (j != i / j) {
                                count++;
                            }
                        }
                    }
                    if (count % 2 == 0) return i;
                    else return i * -1;
                })
                .sum();
    
    }
}