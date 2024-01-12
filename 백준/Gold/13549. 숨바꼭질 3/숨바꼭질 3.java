import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[] visited = new boolean[100001];
    static int time = Integer.MAX_VALUE;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);


        bfs();

        System.out.println(time);
        
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N,0});
        visited[N] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            visited[current[0]] = true;

            if (current[0] == K ) {
                time = Math.min(time, current[1]);
            }

            /**
             * 순간이동한 경우
             */
            if (current[0] * 2 < 100001 && !visited[current[0] * 2])
                queue.add(new int[]{current[0] * 2, current[1]});

            if (current[0] + 1 < 100001 && !visited[current[0] + 1])
                queue.add(new int[]{current[0] + 1, current[1] + 1});

            if (current[0] - 1 >= 0 && !visited[current[0] - 1])
                queue.add(new int[]{current[0] - 1, current[1] + 1});
        }
        
    }
}
