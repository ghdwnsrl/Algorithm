import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] value = br.readLine().split(" ");

        Set<Integer> count = new HashSet<>();
        int N = Integer.parseInt(value[0]);
        int d = Integer.parseInt(value[1]);
        int k = Integer.parseInt(value[2]);
        int c = Integer.parseInt(value[3]);
        int max = Integer.MIN_VALUE;
        
        int[] table = new int[N];
        /* 일단 초밥 넣고 */
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }

        /* k개 만큼 먹여 */
        /* 먹은 종류를 세고 저장해*/
        for (int i = 0; i < table.length; i++) {
            
            if (!count.isEmpty()) {
                count.clear();
            }
            for (int j = 0; j < k; j++) {
                count.add(table[((i + j) % N)]);
            }

            /* count에 쿠폰 번호가 있나 확인하고 있으면 쿠폰 번호와 같은 초밥이 없는 경우 + 1 해서 max 값에 넣어 아님 그냥 넣어 */
            if (count.contains(c)){ // 쿠폰 번호와 같은 초밥이 있는 경우
                max = Math.max(max,count.size());
            } else {
                max = Math.max(max,count.size() + 1);
            }
        }

        System.out.println(max);
    }
}