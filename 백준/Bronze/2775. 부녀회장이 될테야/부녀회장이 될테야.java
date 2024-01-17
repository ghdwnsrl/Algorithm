import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] home = new int[15][15];

        for (int i = 1; i < 15; i++) {
            home[0][i] = i;
        }

        for (int i = 1; i < 15 ; i++) {
            for (int j = 1; j < 15; j++) {
                for (int k = 1; k <= j ; k++) {
                    home[i][j] += home[i-1][k];
                }
            }
        }
        
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            sb.append(home[K][N] + "\n");

        }

        System.out.println(sb);
    }
}
