import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return s.chars()
            .mapToObj(i -> (char) i)
            .sorted(Comparator.reverseOrder())
            .map(String::valueOf)
            .collect(Collectors.joining(""));
    }
}