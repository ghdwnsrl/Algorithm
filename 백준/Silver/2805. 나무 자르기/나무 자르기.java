
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]); // 나무의 수
        int M = Integer.parseInt(s[1]); // 상근이가 가져갈 나무의 길

        int[] trees = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 0;
        int max = 0;
        int mid = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while (min < max) {
            long answer = 0;
            mid = (min + max) / 2;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid)
                    answer += trees[i] - mid;
            }

            if (answer < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}
