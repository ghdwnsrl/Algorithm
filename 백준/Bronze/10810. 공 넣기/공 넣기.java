
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]); // 나무의 수
        int M = Integer.parseInt(s[1]); // 상근이가 가져갈 나무의 길

        int[] answer = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                answer[j] = value;
            }

        }

        for (int i = 1; i < answer.length; i++) {
            System.out.print(answer[i]+ " ");
        }

    }
}