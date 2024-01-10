import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K, count;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st ;

        for (int i = 0; i < T; i++) {
            String[] values = br.readLine().split(" ");
            M = Integer.parseInt(values[0]);
            N = Integer.parseInt(values[1]);
            K = Integer.parseInt(values[2]);

            field = new int[M][N];
            visited = new boolean[M][N];
            count = 0;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }


            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (field[j][k] == 1 && !visited[j][k]){
                        count++;
                        bfs(j,k);
                    }
                }
            }

            System.out.println(count);
        }


    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentPosition[0] + dx[i];
                int nextY = currentPosition[1] + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (field[nextX][nextY] == 1 && !visited[nextX][nextY]) { // 양배추가 있고, 방문 안 했으면 ?
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX,nextY});
                    }
                }
            }

        }
    }
}
