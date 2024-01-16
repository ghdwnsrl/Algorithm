import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while(!(line = br.readLine()).equals("0")) {

            N = Integer.parseInt(line);

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = bfs();
            sb.append("Problem " + index++ + ": "+ answer+"\n");
        }

        System.out.println(sb);

    }

    private static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        int[][] move = new int[N][N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i],Integer.MAX_VALUE);
        }

        queue.add(new int[]{0,0,map[0][0]});
        move[0][0] = map[0][0];

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int currentX = current[0], currentY = current[1], cost = current[2];

            // 동굴의 끝이라면?
            if (currentX == N-1 && currentY == N-1) {
                min = Math.min(min,cost);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    int nextCost = cost + map[nextX][nextY];
                    if (move[nextX][nextY] > nextCost) {
                        move[nextX][nextY] = nextCost;
                        queue.add(new int[]{nextX, nextY, nextCost});
                    }
                }

            }

        }
        return min;
    }
}