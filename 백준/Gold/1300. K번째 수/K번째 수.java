import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long lo = 1;
        long high = K;

        while (lo < high){
            long mid = (lo + high) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min( mid / i ,N);
            }

            if (K > count) {
                lo = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(lo);

    }
}