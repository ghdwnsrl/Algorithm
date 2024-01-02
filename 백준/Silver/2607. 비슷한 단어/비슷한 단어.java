import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            int count = 0;
            int[] word = new int[26];

            for (int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for (int j = 0; j < str.length(); j++) {
                if (word[str.charAt(j)-'A'] > 0){
                    count++;
                    word[str.charAt(j)-'A']--;
                }
            }

            if (first.length() == str.length() && (count == first.length() || count == first.length() - 1)){
                answer++;
            }
            else if (first.length() == str.length() - 1 && str.length() - 1 == count){
                answer++;
            }
            else if (first.length() == str.length() + 1 && str.length() == count) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

