import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int midx = -1;
        
        for (int i =0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                midx = i;
            }
        }
        
        int[] answer;
        if (arr.length != 1){
            answer = new int[arr.length - 1];
            int aIdx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (midx == i) continue;
                answer[aIdx++] = arr[i];
            }
        } else {
            answer = new int[]{-1};
        }
        return answer;
    }
}