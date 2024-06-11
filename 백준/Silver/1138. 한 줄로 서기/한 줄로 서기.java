
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[N];

        for (int i = 1; i <= N; i++) {

            int left = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                if (left == 0 && answer[j] == 0) {
                    answer[j] = i;
                    break;
                }
                if (answer[j] == 0) left--;
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
