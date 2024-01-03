import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int K = Integer.parseInt(arr[0]);
        int N = Integer.parseInt(arr[1]);
        int[] values = new int[K];

        long right = -1;
        for (int i = 0 ; i < K ; i ++) {
            values[i] = Integer.parseInt(br.readLine());
            right = Math.max(values[i], right);
        }

        long left = 1;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < values.length; i++) {
                count += values[i] / mid;
            }

            if (count >= N) {
                left = mid + 1;
                answer = Math.max(answer,mid);
            } else if (count < N) {
                right = mid - 1;
            }

        }
        System.out.println(answer);
    }
}

