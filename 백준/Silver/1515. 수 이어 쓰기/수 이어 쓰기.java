import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0 ;
        while (true) {
            result ++;
            String cmp = Integer.toString(result);
            while (cmp.length() > 0 &&  input.length() > 0) {
                if (cmp.charAt(0) == input.charAt(0))
                    input = input.substring(1);

                cmp = cmp.substring(1);
            }

            if (input==""){
                System.out.println(result);
                break;
            }

        }
    }
}