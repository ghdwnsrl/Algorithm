
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            System.out.println(answer(B[i]));
        }
    }

    private static int answer(int target) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if ( A[mid] ==  target){
                return 1;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
