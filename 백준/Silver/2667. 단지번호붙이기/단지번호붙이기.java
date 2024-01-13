import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = value.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1){
                    int result = bfs(i,j);
                    if (result != 0)
                        list.add(result);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }

    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if (nextX < N && nextX >= 0 && nextY >= 0 && nextY < N ){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1){
                        visited[currentX + dx[i]][currentY + dy[i]] = true;
                        count++;
                        queue.add(new int[] {nextX,nextY});
                    }
                }
            }
        }

        return count;
    }
}