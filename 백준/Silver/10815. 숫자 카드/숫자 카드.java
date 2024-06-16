
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] answer, mine, cmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        mine = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            mine[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        cmp = new int[M];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cmp[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(mine);

        for (int i = 0; i < M; i++) {
            boolean isContain = binarySearch(cmp[i]);
            if (isContain) {
                answer[i] = 1;
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

    private static boolean binarySearch(int target) {
        int start = 0;
        int end = mine.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (target < mine[mid]) {
                end = mid - 1;
            } else if (target > mine[mid]){
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
