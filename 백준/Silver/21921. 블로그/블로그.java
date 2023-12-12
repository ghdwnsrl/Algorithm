import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int answerCnt = 1;

        for (int i = 0; i < x; i++) {
            answer += arr[i];
        }

        int sum = answer;
        for (int i = x; i < n; i++) {
            sum += arr[i] - arr[i - x] ;
            if (answer < sum) {
                answer = sum;
                answerCnt = 1;
            } else if (answer == sum) {
                answerCnt++;
            }

        }

        if (answer == 0)
            System.out.println("SAD");
        else{
            System.out.println(answer);
            System.out.println(answerCnt);

        }


    }
}