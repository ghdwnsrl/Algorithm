import java.util.stream.IntStream;

class Solution {
    public boolean solution(int x) {
        int sum = String.valueOf(x).chars()
                .map(c -> c - '0')
                .sum();
        if (x % sum == 0) return true;
        else return false;
    }
}