import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!stack.empty()) {
                if (stack.peek()[1] >= value) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.empty())
                System.out.print("0 ");

            stack.push(new int[]{i, value});
        }

    }
}

