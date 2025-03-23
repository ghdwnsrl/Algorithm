import java.util.*;

class Solution {
    static boolean[] visited;
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        N = n;
        
        for(int i=0; i<n; i++) {
            if (visited[i]) continue;
            dfs(i, computers);
            answer++;
        }
        
        return answer;
    }
    
    static void dfs(int node, int[][] computers) {
        visited[node] = true;
        for(int i = 0; i < N; i++) {
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}