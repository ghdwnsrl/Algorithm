
import java.io.*;

public class Main {

    private static int N, K, answer = 0;
    private static int[] belt;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        K = Integer.parseInt(values[1]);

        belt = new int[2 * N];
        robot = new boolean[2 * N];

        String[] As = br.readLine().split(" ");
        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(As[i]);
        }

        start();
        System.out.println(answer);
    }

    private static void start() {

        while (isOk()) {
            int tmpBelt = belt[belt.length - 1];
            boolean tmpRobot = robot[robot.length - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
                robot[i] = robot[i - 1];

            }
            belt[0] = tmpBelt;
            robot[0] = tmpRobot;

            if (robot[N - 1]) {
                robot[N - 1] = false;
            }

            for (int i = robot.length - 1; i > 0; i--) {
                if (!robot[i] && robot[i - 1] && belt[i] >= 1) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                }
            }

            if (robot[N - 1]) {
                robot[N - 1] = false;
            }

            if (belt[0] > 0 && !robot[0]){
                robot[0] = true;
                belt[0]--;
            }

            answer++;
        }
    }

    private static boolean isOk() {
        int cnt = 0;
        
        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0)
                cnt++;
            if (cnt >= K)
                return false;
        }

        return true;
    }
}
