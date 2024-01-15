import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] time;
    static int N;
    static int K;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        visited = new boolean[100001];
        time = new int[100001];

        bfs();

        System.out.println(min);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N,0});
        visited[N] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            if (current[0] == K) {
                min = Math.min(current[1], min);
            }

            if ( current[0] + 1 >= 0 && current[0] + 1 < 100001 &&
                    !visited[current[0] + 1]
            ) /* 범위 안에 있고 */ {
                visited[current[0] + 1] = true;
                queue.add(new int[] {current[0] + 1, current[1] + 1});
            }

            if ( current[0] - 1 >= 0 && current[0] - 1 < 100001 &&
                    !visited[current[0] - 1]
            ) /* 범위 안에 있고 */ {
                visited[current[0] - 1] = true;
                queue.add(new int[] {current[0] - 1, current[1] + 1});
            }

            if ( current[0] * 2 >= 0 && current[0] * 2 < 100001 &&
                    !visited[current[0] * 2]
            ) /* 범위 안에 있고 */ {
                visited[current[0] * 2 ] = true;
                queue.add(new int[] {current[0] * 2, current[1] + 1});
            }
        }
    }
}
