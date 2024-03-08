import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Node {

        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R,C;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static int[][] jhTime, fireTime;

    static int answer;

    static Queue<Node> fireQueue, jhQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        R = array[0];
        C = array[1];
        map = new char[R][C];
        jhTime = new int[R][C];
        fireTime = new int[R][C];

        fireQueue = new LinkedList<>();
        jhQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                fireTime[i][j] = -1;
                jhTime[i][j] = -1;

                if (s.charAt(j) == 'J') {
                    jhQueue.offer(new Node(i,j));
                    jhTime[i][j] = 0;
                }
                else if (s.charAt(j) == 'F') {
                    fireQueue.offer(new Node(i,j));
                    fireTime[i][j] = 0;
                }
            }
        }

        answer();
    }

    private static void answer() {

        while (!fireQueue.isEmpty()) {

            Node current = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nxtX = current.x + dx[i];
                int nxtY = current.y + dy[i];

                // 범위 밖일 경우
                if (nxtX >= R || nxtX < 0 || nxtY >= C || nxtY < 0)
                    continue;

                // 벽 or 이미 방문한 경우
                if (map[nxtX][nxtY] == '#' || fireTime[nxtX][nxtY] >= 0)
                    continue;

                fireTime[nxtX][nxtY] = fireTime[current.x][current.y] + 1;
                fireQueue.offer(new Node(nxtX,nxtY));

            }
        }

        while (!jhQueue.isEmpty()) {

            Node current = jhQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nxtX = current.x + dx[i];
                int nxtY = current.y + dy[i];

                // 범위 밖? => 탈출 성공
                if (nxtX >= R || nxtX < 0 || nxtY >= C || nxtY < 0) {
                    System.out.println(jhTime[current.x][current.y] + 1);
                    return;
                }

                // 벽 or 이미 방문한 경우
                if (map[nxtX][nxtY] == '#' || jhTime[nxtX][nxtY] >= 0)
                    continue;

                // 불보다 느린 경우
                if (fireTime[nxtX][nxtY] <= jhTime[current.x][current.y] + 1 && fireTime[nxtX][nxtY] != -1)
                    continue;

                jhTime[nxtX][nxtY] = jhTime[current.x][current.y] + 1;
                jhQueue.offer(new Node(nxtX, nxtY));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}