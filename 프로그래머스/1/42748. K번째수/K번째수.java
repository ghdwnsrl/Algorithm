import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        int answerIdx = 0;

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] arr = new int[j - i + 1];
            int arrIdx = 0;
            for (int l = i - 1; l < j; l++) {
                arr[arrIdx++] = array[l];
            }
            Arrays.sort(arr);

            answer[answerIdx++] = arr[k - 1];

        }
        return answer;
    }
}