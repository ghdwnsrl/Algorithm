import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    private static int good;
    private static int N;
    private static int[] inputs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = Stream.of(br.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(inputs);

        for (int i = 0; i < N; i++) {
            answer(i);
        }
        System.out.println(good);
    }

    private static void answer(int targetIdx) {

        int start = 0;
        int end = N-1;
        int target = inputs[targetIdx];

        while (start < end) {

            int sum = inputs[start] + inputs[end];

            // 값이 더 작아져야 함
            if ( sum > target) {
                end--;
            } else if (sum < target){ // 값이 커져야 함
                start++;
            } else {
                if (start == targetIdx)
                    start++;
                else if (end == targetIdx)
                    end--;
                else {
                    good++;
                    return;
                }
            }
        }

    }
}