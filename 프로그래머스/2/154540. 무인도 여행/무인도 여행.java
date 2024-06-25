import java.util.*;

class Solution {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static char[][] map;

    public List<Integer> solution(String[] maps) {
        
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(answer);
        
        if (answer.size() == 0) {
            answer.add(-1);
        }
        
        return answer;
    }
    
    private static int bfs(int i, int j) {

        int total = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!que.isEmpty()) {

            int[] poll = que.poll();
            int curX = poll[0];
            int curY = poll[1];

            total += map[curX][curY] - '0';

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
                    continue;
                }

                if (map[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    que.offer(new int[]{nextX,nextY});
                }
            }

        }

        return total;

    }
}