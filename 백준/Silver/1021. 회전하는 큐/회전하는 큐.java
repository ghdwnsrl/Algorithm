
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] find;
    static LinkedList<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] value = br.readLine().split(" ");
        N = Integer.parseInt(value[0]);
        M = Integer.parseInt(value[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        queue = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            queue.add(i);
        }

        find = new int[M];

        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < find.length; i++) {
            int cmp = find[i];
            while (true) {
                boolean isOver = true;
                if (cmp == queue.peek()) {
                    queue.removeFirst();
                    break;
                }
                for (int j = 0; j <= queue.size() / 2; j++) {
                    if (queue.get(j) == cmp) {
                        Integer first = queue.removeFirst();
                        queue.addLast(first);
                        cnt++;
                        isOver = false;
                    }
                }

                if (isOver)  {
                    Integer last = queue.removeLast();
                    queue.addFirst(last);
                    cnt++;
                }

            }

        }

        System.out.println(cnt);
    }
}
