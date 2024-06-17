
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, L;
    static int[] rest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        L = Integer.parseInt(inputs[2]);
        StringTokenizer st = new StringTokenizer(br.readLine());

        rest = new int[N + 2];
        rest[0] = 0;
        rest[N+1] = L;

        for (int i = 1; i <= N; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rest);
        anwser();

    }

    private static void anwser() {
        int start = 1;
        int end = L - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 0;
            for (int i = 0; i < N + 1; i++) {
                int dist = rest[i + 1] - rest[i];
                count += dist / mid;
                if (dist % mid == 0) count--;
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
