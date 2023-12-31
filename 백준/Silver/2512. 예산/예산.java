import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int right = -1;
        int left = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);
        }

        int M = Integer.parseInt(br.readLine());
        while (left <= right) {
            int mid = (left + right) / 2;
            int budget = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) budget += mid;
                else budget += arr[i];
            }
            if (budget <= M)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(right);

    }
}