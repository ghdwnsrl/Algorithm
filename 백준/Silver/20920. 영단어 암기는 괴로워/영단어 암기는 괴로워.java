import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        
        Map<String, Integer> wordMap = new HashMap<>();
        
        while (N-- > 0) {
            String word = br.readLine();

            if (word.length() >= M) {
                if (!wordMap.containsKey(word))
                    wordMap.put(word,1);
                else /* 값이 있는 경우 */
                    wordMap.put(word , wordMap.get(word) + 1);

            }
        }

        List<String> keys = new ArrayList<>(wordMap.keySet());

        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String v1, String v2) {
                /* 빈도 수  */
                if (Integer.compare(wordMap.get(v1) , wordMap.get(v2)) != 0 ){
                    return Integer.compare(wordMap.get(v2) , wordMap.get(v1));
                }
                /* 단어 길이 순*/
                if (v1.length() != v2.length())
                    return v2.length() - v1.length();

                /* 사전 순 */
                return v1.compareTo(v2);
            }
        });

        for (String key : keys) {
            sb.append(key+"\n");
        }
        System.out.println(sb);

    }
}