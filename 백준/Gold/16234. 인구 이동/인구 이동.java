import java.io.*;
import java.util.*;

public class Main {

    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;
    private static StringTokenizer st;
    private static int answer = 0;
    private static boolean isMove;

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        L = Integer.parseInt(split[1]);
        R = Integer.parseInt(split[2]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(answer);

    }

    public static void move() {

        while (true) {
            isMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            if (!isMove) return;
            answer++;
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y, map[x][y]});
        List<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y, map[x][y]});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int people = poll[2];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if (nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {

                    int nextPeople = map[nextX][nextY];

                    if (!visited[nextX][nextY]) {
                        int value = Math.abs(nextPeople - people);
                        if ( value >= L && value <= R) {
                            queue.add(new int[] {nextX, nextY, map[nextX][nextY]});
                            visited[nextX][nextY] = true;
                            union.add(new int[] {nextX, nextY, map[nextX][nextY]});
                        }
                    }
                }
            }
        }

        if (union.size() > 1) {
            int avr = (int) union.stream().mapToInt(u -> u[2])
                    .summaryStatistics()
                    .getAverage();

            union.forEach(u -> map[u[0]][u[1]] = avr);
            isMove = true;
        }
    }
}
