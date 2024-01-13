import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int time[] = new int[100001];
    static int count = 0;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");

        N = Integer.parseInt(value[0]);
        K = Integer.parseInt(value[1]);

        if(N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }
        
        bfs();

        System.out.println(min);
        System.out.println(count);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (min < time[current]) {
                return;
            }
            for (int i =0 ; i < 3  ;i ++) {

                int next;

                if (i == 0)         next = current + 1;
                else if (i == 1)    next = current - 1;
                else                next = current * 2;


                if (next > 100000 || next < 0) // 범위 이탈
                    continue;

                if (next == K){
                    min = time[current];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[current] + 1) {
                    queue.add(next);
                    time[next] = time[current] + 1;
                }

            }

        }
    }
}
