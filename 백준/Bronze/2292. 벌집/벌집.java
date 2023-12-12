import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        
        int cnt = 1;
        int cmp = 1;
        int index = 1;
        
        while (true) {

            if (cmp < input) {
                cmp = cmp + ( 6 * index++ ) ;
                cnt ++;
            } else
                break;
        }

        System.out.println(cnt);
    }
}