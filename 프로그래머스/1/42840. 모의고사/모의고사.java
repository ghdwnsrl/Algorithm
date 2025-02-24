import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (s1[i % 5] == answers[i] ) scores[0] ++;
            if (s2[i % 8] == answers[i] ) scores[1] ++;
            if (s3[i % 10] == answers[i] ) scores[2] ++;
        }

        int max = Arrays.stream(scores)
                .max()
                .orElse(0);

        return IntStream.rangeClosed(0, scores.length - 1)
                .mapToObj((idx) -> new int[]{idx + 1, scores[idx]})
                .filter(student -> student[1] == max)
                .sorted(Comparator.comparingInt(student -> student[0]))
                .mapToInt(student -> student[0])
                .toArray();
    }
}