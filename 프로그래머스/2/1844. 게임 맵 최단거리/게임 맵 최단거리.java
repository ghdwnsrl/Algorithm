import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        boolean[][] visited  = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited);
    }
    
    static int bfs(int[][] maps, boolean[][] visited) {
        int answer = -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            // 상대방 진영 도착
            if(cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
                return cur[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];
                
                // 범위 내 
                if(nX >= 0 && nX < maps.length && nY >= 0 && nY < maps[0].length) {
                    if(!visited[nX][nY] && maps[nX][nY] == 1) {
                        visited[nX][nY] = true;
                        queue.offer(new int[]{nX, nY, cur[2] + 1});
                    }
                }
            }
        }
        
        return answer;
    }
}