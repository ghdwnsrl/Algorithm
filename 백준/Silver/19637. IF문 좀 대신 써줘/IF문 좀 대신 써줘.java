import java.io.*;
import java.util.*;

public class Main {

    static public class Condition {
        String name;
        int condition;

        public Condition(String name, int condition) {
            this.name = name;
            this.condition = condition;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        List<Condition> conditions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] value = br.readLine().split(" ");
            String title = value[0];
            int condition = Integer.parseInt(value[1]);
            conditions.add(new Condition(title,condition));
        }

        for (int i = 0; i < M; i++) {

            int score = Integer.parseInt(br.readLine());

            int start = 0;
            int end = conditions.size() - 1;

            while (start <= end ) {
                int middle = (start + end) / 2;

                Condition cond = conditions.get(middle);
                if (cond.condition >= score ) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }

            }

            sb.append(conditions.get(start).name + "\n");
        }

        System.out.println(sb);
    }
}