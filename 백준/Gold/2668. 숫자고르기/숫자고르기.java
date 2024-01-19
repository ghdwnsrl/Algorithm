import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < arr.length; i++) {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(answer.size() + "\n");
        for (Integer i : answer) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
        
    }

    private static void dfs(int i, int end) {

        if (arr[i] == end) answer.add(arr[i]);
        
        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i] , end);
            visited[arr[i]] = false;
        }
    }
}