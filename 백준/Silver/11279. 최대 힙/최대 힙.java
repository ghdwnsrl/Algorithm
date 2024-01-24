import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < x; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(queue.poll()+"\n");

                continue;
            }
            queue.add(input);
        }
        System.out.println(sb);
    }
}