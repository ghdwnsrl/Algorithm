import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] server;
    static long half = 0;

    static int lowerBound() {
        int start = 0, end = server[server.length - 1], mid = 0;
        long tmpSum = 0;

        while (start < end) {
            mid = (start + end) / 2;

            for (int i = 0; i < server.length; i++) {
                if (server[i] >= mid)
                    tmpSum += mid;
                else
                    tmpSum += server[i];
            }

            if (tmpSum >= half)
                end = mid;
            else
                start = mid + 1;

            tmpSum = 0;
        }

        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        server = new int[N * N];

        int index = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp =  Integer.parseInt(st.nextToken());
                sum += tmp;
                server[index++] = tmp;
            }
        }


        half = Math.round(sum / 2.0);

        Arrays.sort(server);

        System.out.println(lowerBound());
    }
}
