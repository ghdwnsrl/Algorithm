import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            String input = br.readLine();
            for (int j = 1; j < M+1 ; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1,1});
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int count = poll[2];

            if (currentX == N && currentY == M) {
                answer = Math.min(count,answer);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX > 0 && nextX <= N && nextY > 0 && nextY <= M) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX,nextY, count+1});
                    }
                }
            }
        }
    }
}
