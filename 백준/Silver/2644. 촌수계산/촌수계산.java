import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        String[] split = br.readLine().split(" ");

        int start =  Integer.parseInt(split[0]);
        int end =  Integer.parseInt(split[1]);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] value = br.readLine().split(" ");
            int p = Integer.parseInt(value[0]);
            int c = Integer.parseInt(value[1]);
            graph[p].add(c);
            graph[c].add(p);
        }

        dfs(start,end,0);
        System.out.println(count);
    }

    private static void dfs(int start, int end, int cnt) {

        if (start == end) {
            count = cnt;
            return;
        }

        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            if (!visited[graph[start].get(i)]) {
                dfs(graph[start].get(i), end, cnt + 1);
            }
        }
    }
}