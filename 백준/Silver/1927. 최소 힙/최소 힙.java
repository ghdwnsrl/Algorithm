import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (priorityQueue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(priorityQueue.poll());
            } else {
                priorityQueue.add(value);
            }
        }

    }
}