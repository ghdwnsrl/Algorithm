import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * https://january-diary.tistory.com/entry/BOJ-4659-%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8-%EB%B0%9C%EC%9D%8C%ED%95%98%EA%B8%B0-JAVA
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;
        int count;
        char[] pass;
        char prev;
        boolean flag;
        while (!(password = br.readLine()).equals("end")) {
            pass = password.toCharArray();
            count = 0;
            prev = '.';

            flag = false;

            for (char ch : pass) {
                /**
                 * 조건 1.
                 */
                if (isVowel(ch))
                    flag = true;


                /**
                 * 조건 2.
                 */
                if (isVowel(ch) != isVowel(prev))
                    count = 1;
                else
                    count ++;


                /**
                 * 조건 3.
                 */
                if (count > 2 || (ch == prev && (ch != 'e' && ch != 'o'))) {
                    flag = false;
                    break;
                }

                prev = ch;

            }

            if (flag)
                System.out.println("<" + password+"> is acceptable.");
            else
                System.out.println("<" + password+"> is not acceptable.");

        }
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}