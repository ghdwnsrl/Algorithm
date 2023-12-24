import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int N = Integer.parseInt(br.readLine());
        int answer;

        while (N > 0) {
            answer = 0;
            N--;
            int[] values = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            for (int i = 1; i < values.length; i++) {
                for (int j = i; j > 0 ; j--) {
                    if (values[i] < values[j])
                        answer++;
                }
            }
            System.out.println(values[0] + " "  + answer);
        }
    }
}