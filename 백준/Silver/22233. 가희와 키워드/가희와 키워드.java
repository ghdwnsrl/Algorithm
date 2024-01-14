import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] value = br.readLine().split(" ");
        int N = Integer.parseInt(value[0]);
        int M = Integer.parseInt(value[1]);

        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(",");
            for (int j = 0; j < split.length; j++) {
                if (map.containsKey(split[j]))
                    map.remove(split[j]);
            }
            sb.append(map.size() + "\n");
        }

        System.out.println(sb);


    }
}
