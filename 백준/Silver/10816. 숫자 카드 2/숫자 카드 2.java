import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] cards;

    public static void main(String[] args) throws IOException {

        // 1. 숫자 N 과 크기가 N인 int형 배열 cards를 받는다.
        // 2. 숫자 M 과 크기가 M인 int형 배열 haves를 받는다.
        // 3. cards를 정렬한다.
        // 4. 이진 탐색 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(cards);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key= Integer.parseInt(st.nextToken());
            sb.append(upper(key) - lower(key)).append(' ');
        }

        System.out.println(sb);


    }

    private static int lower(int key) {

        int min = 0, max = cards.length;

        while (min < max) {
            int mid = (min + max) / 2;
            if (key <= cards[mid]) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return min;
    }

    private static int upper(int key) {

        int min = 0, max = cards.length;

        while (min < max) {
            int mid = (min + max) / 2;
            if (key < cards[mid]) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return min;
    }

}