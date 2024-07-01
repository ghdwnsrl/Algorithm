import java.util.*;

class Solution {
    
    static List<int[]> answer;
    
    public int[][] solution(int n) {
        answer = new ArrayList<>();
        hanoi(n,1,2,3);

        return answer.stream()
                .toArray(int[][]::new);
    }
    
    public static void hanoi(int N, int from, int mid, int to) {
        if (N == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        hanoi(N -1, from, to, mid );
        answer.add(new int[]{from, to});
        hanoi(N -1, mid, from, to);
    }
}