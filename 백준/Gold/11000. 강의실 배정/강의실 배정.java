import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            lectures[i] = new Lecture(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
        }

        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(lectures[0].end);

        for (int i = 1; i < N ; i++) {

            if (queue.peek() <= lectures[i].start) {
                queue.poll();
            }

            queue.add(lectures[i].end);
        }
        
        System.out.println(queue.size());
    }

    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
