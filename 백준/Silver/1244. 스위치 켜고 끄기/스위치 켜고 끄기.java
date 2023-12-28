import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            String[] split = br.readLine().split(" ");
            int sex = Integer.parseInt(split[0]);
            int num = Integer.parseInt(split[1]);

            // 남
            if (sex == 1) {
                for (int i = num - 1; i < array.length ; i += num) {
                    array[i] = (array[i] == 1 ? 0 : 1 );
                }

            } else if (sex == 2) { // 여
                int left = num - 2;
                int right = num;

                while (right < array.length && left >= 0) {
                    if (array[left] != array[right]) {
                        break;
                    }
                    left--;
                    right++;
                }
                for (int i = left + 1; i < right; i++) {
                    array[i] = (array[i] == 1 ? 0 : 1);
                }
            }

        }

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");

            if ((i+1) % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }
}