import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[100][100];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            for (int j = x; j < x + 10 ; j++) {
                for (int k = y; k < y + 10 ; k++) {
                    if (arr[j][k] != 1){
                        arr[j][k] = 1;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

