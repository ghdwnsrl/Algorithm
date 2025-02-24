import java.util.stream.*;

class Solution {
    public String solution(String[] seoul) {
        return IntStream.rangeClosed(0, seoul.length)
                .filter(idx -> seoul[idx].equals("Kim"))
                .mapToObj(s -> "김서방은 " + s + "에 있다")
                .findFirst()
                .orElse(String.valueOf(-1));
    }
}