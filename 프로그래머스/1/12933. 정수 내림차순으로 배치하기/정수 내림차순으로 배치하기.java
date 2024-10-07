import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
    public long solution(long n) {
        
        List<Long> list = new ArrayList<>();
        
        while(n/10 > 0) {
            list.add(n % 10);
            n /= 10;
        }
        if(n > 0) {
            list.add(n);
        }
        
        String result = list.stream()
            .sorted(Comparator.reverseOrder())
            .map(String::valueOf)
            .collect(Collectors.joining(""));
        
        return Long.valueOf(result);
    }
}