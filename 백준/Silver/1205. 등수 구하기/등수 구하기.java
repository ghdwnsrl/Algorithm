import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine = br.readLine().split(" ");

        int N =  Integer.parseInt(firstLine[0]);
        int value =  Integer.parseInt(firstLine[1]);
        int P =  Integer.parseInt(firstLine[2]);

        if (N == 0 ){
            System.out.println(1);
            return;
        }

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 1;
        int stack = 0;
        for (int i = 0 ; i < N ; i++) {
            if (value < input[i]) {
                answer++;
            }else if (value == input[i]) {
                stack++;
            } else {
                break;
            }
        }

        if (answer + stack > P)
            System.out.println(-1);
        else
            System.out.println(answer);


    }
}