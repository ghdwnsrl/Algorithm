import java.io.*;
import java.util.*;

public class Main {

    static int[][][] box;
    static boolean[][][] visited;

    static int[] dx = {0,0,0,0,1,-1};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {1,-1,0,0,0,0};
    static Queue<int[]> queue = new LinkedList<>();

    static int M,N,H;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        H = Integer.parseInt(split[2]);

        box = new int[N][M][H];
        visited = new boolean[N][M][H];
        int x= 0,y =0;
        StringTokenizer st;
        boolean flag = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    box[j][k][i] = tmp;
                    if (tmp == 1 ){
                        queue.add(new int[]{j,k,i,0});
                        visited[j][k][i] = true;
                    }

                    if (tmp == 0)
                        flag = true;
                }
            }
        }

        if (flag)
            bfs();
        else
            answer = 0;

        System.out.println(answer);

    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentZ = poll[2];
            int currentDay = poll[3];
            answer = Math.max(currentDay,answer);
            for (int i = 0; i < 6; i++) {

                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                int nextZ = currentZ + dz[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >= 0 && nextZ < H){
                    if (!visited[nextX][nextY][nextZ] && box[nextX][nextY][nextZ] == 0 ) {
                        visited[nextX][nextY][nextZ]= true;
                        box[nextX][nextY][nextZ] = 1;
                        queue.add(new int[]{nextX,nextY,nextZ,currentDay + 1});
                    }

                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[j][k][i] == 0) {
                        answer = -1;
                        return;
                    }
                }
            }
        }

    }
}