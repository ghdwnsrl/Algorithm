import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] table = sc.next().toCharArray();

        int count = 0 ;

        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                // P 라면 K 번째로 먼 버거 먼저 먹기
                boolean isEat = false;
                int index = Math.max( i - K , 0 );
                for (int j = index ; j < i; j++) {
                    if (isEat)
                        break;
                    if (table[j] == 'H' ) {
                        table[j] = '.';
                        count++;
                        isEat = true;
                    }
                }

                if (!isEat) {
                    int rightIndex = ((i + K) >= N ? N - 1 : (i + K));
                    for (int x = i + 1; x <= rightIndex ; x++) {
                        if (isEat) {
                            break;
                        }
                        if (table[x] == 'H') {
                            table[x] = '.';
                            count++;
                            isEat = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}