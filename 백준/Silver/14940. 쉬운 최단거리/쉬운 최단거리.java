import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map,distance;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;

    private static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");
        n = Integer.parseInt(value[0]);
        m = Integer.parseInt(value[1]);

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        int x = 0 , y = 0;

        for (int i = 0; i < n; i++) { // m = 가로
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) { // n = 세로
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) { // 목표 지점
                    x = i;
                    y = j;
                } else if (map[i][j] == 0) { // 못 가는 땅 ..
                    visited[i][j] = true;
                }
            }
        }

        bfs(x,y);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) { // 도달할 수 없는 위치
                    distance[i][j]=-1;
                }
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentPosition[0] + dx[i];
                int nextY = currentPosition[1] + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1 ) {
                        distance[nextX][nextY] = distance[currentPosition[0]][currentPosition[1]] + 1;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX,nextY});
                    }
                }

            }

        }
    }
}