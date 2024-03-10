import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int min = Integer.MAX_VALUE;
        int aCount = 0;

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == 'a' )
                aCount ++;
        }

        for (int i = 0; i < value.length(); i++) {
            int bCount = 0;
            for (int j = i; j < i + aCount; j++) {
                if (value.charAt( j % value.length()) == 'b')
                    bCount++;
            }

            min = Math.min(min, bCount);

        }
        System.out.println(min);
    }
}