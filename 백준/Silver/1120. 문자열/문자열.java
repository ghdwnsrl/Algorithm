import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        String A = arr[0];
        String B = arr[1];

        int answer = 50;

        for (int i = 0; i < B.length() - A.length() + 1; i++) {

            int count = 0;

            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j+i))
                    count++;
            }

            answer = Math.min(count,answer);
        }

        System.out.println(answer);

    }
}