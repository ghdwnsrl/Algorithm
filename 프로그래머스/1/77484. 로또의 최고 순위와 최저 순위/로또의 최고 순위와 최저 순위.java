class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int hit = 0;
        int zero = 0;
        int[] rank = {6,6,5,4,3,2,1};
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    hit++;
                    break;
                }
            }
        }
        return new int[]{rank[hit + zero], rank[hit]};
    }
}