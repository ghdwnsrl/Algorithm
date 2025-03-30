import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = 0;        
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        return bfs(maps, visited);
    }
    
    static int bfs(int[][] maps, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        int answer = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
                answer = cur[2];
                return answer;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, cur[2] + 1});
                    }
                }
            }
        }
        return answer;
    }
}