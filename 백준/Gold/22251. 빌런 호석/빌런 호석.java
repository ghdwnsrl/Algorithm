import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K, P, X;

    static int[][] digit = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] dig_x = trans_arr(X);
        int answer = 0;
        for (int i = 1; i <= N ; i++) {
            if (i == X) continue;
            if (possible(i, dig_x)) answer++;
        }

        System.out.println(answer);
    }

    private static int[] trans_arr(int x) {
        int[] transed_x = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            transed_x[i] = x % 10;
            x /= 10;
        }
        return transed_x;
    }

    private static boolean possible(int cmp, int[] dig_x) {

        int[] dig_cmp = trans_arr(cmp);
        int count = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if (digit[dig_cmp[i]][j] != digit[dig_x[i]][j]) count++;
                if (count > P) return false;
            }
        }
        return true;
    }
}
