import java.util.LinkedList;
import java.util.Queue;
class Solution {
    
    static class Pos {
        int x;
        int y;
        int level;

        public Pos(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static char[][] map;
    public int solution(String[] maps) {
        int answer = -1;
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        Pos start = null, end = null, lever = null;
        for (int i = 0; i < maps.length; i ++ ) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new Pos(i, j,0);
                }
                if (maps[i].charAt(j) == 'E') {
                    end = new Pos(i, j,0);
                }
                if (maps[i].charAt(j) == 'L') {
                    lever = new Pos(i, j,0);
                }
                map[i][j] = maps[i].charAt(j);
            }
        }

        int toLever = bfs(start, lever);

        if (toLever != -1) {
            visited = new boolean[maps.length][maps[0].length()];
            int toEnd = bfs(lever, end);
            if (toEnd != -1) {
                answer = toLever + toEnd;
            }
        }
        
        return answer;
    }
    
    public static int bfs(Pos from, Pos to) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(from);
        visited[from.x][from.y] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            if (current.x == to.x && current.y == to.y){
                return current.level;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                    continue;
                }
                if (!visited[nextX][nextY] && map[nextX][nextY] != 'X'){
                    queue.add(new Pos(nextX, nextY, current.level + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }
}