import java.util.*;

class Solution {
    class Fail {
        int stage;
        double rate;

        public Fail(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }
    public int[] solution(int n, int[] stages) {
        int totalPlayers = stages.length;
        List<Fail> fails = new ArrayList<>();
        int[] answer = new int[n];
        // 각 스테이지별 유저 수
        int[] users = new int[n+2];
        for (int stage : stages) {
            users[stage]++;
        }

        // 실패율 계산
        for (int i = 1; i <= n; i++) {
            double rate = 0;
            if (totalPlayers > 0)
                rate = (double) users[i] / totalPlayers;
            totalPlayers -= users[i];
            fails.add(new Fail(i, rate));
        }

        fails.sort((f1, f2) -> {
            if (Double.compare(f2.rate, f1.rate) == 0) {
                return Integer.compare(f1.stage, f2.stage);
            }
            return Double.compare(f2.rate, f1.rate);
        });

        for(int i = 0; i < n; i++) {
            answer[i] = fails.get(i).stage;
        }
        
        return answer;
    }
}