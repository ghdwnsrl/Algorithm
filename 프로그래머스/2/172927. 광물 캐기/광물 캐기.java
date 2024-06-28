
import java.util.*;

class Solution {
    static class Mineral {
        int diamond;
        int iron;
        int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    static int[][] score = {
            {1,1,1},
            {5,1,1},
            {25,5,1}
    };
    
    public int solution(int[] picks, String[] minerals) {
        
        List<Mineral> mineralList = new LinkedList<>();
        int pickTotal = Arrays.stream(picks).sum();

        for (int i = 0; i < minerals.length; i+=5) {
            if (pickTotal == 0) break;

            int dia = 0;
            int iron = 0;
            int stone = 0;
            for (int j = i; j < i+5; j++) {
                if (j == minerals.length) break;

                String mineral = minerals[j];
                int kind = mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;

                dia += score[0][kind];
                iron += score[1][kind];
                stone += score[2][kind];
            }
            mineralList.add(new Mineral(dia, iron, stone));
            pickTotal--;
        }

        Collections.sort(mineralList, (m1, m2) -> (m2.stone - m1.stone));

        int answer = 0;
        for (Mineral mineral : mineralList) {
            int dia = mineral.diamond;
            int iron = mineral.iron;
            int stone = mineral.stone;

            if (picks[0] > 0) {
                picks[0]--;
                answer += dia;
                continue;
            } else if (picks[1] > 0){
                picks[1]--;
                answer += iron;
                continue;
            } else {
                picks[2]--;
                answer += stone;
                continue;
            }

        }
        
        return answer;
    }
}