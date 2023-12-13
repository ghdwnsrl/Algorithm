import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length() ; i ++) {
            int cmp = input.charAt(i);
            /* 대문자인 경우 */
            if ( cmp >= 65 && cmp <= 90 ) {
                arr[cmp-65]++;
            } else {
                /* 소문자인 경우*/
                arr[cmp-97]++;
            }
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max  = arr[i];
                ch =  (char) (i + 65);
            } else if (max == arr[i])
                ch = '?';
        }

        System.out.println(ch);


    }
}