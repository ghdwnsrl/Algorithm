import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bit = 0;
        int value=0;
        while (M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (!(op.equals("all") || op.equals("empty"))){
                value = Integer.parseInt(st.nextToken()) - 1;
            }
            switch (op){
                case "add" :
                    bit |= (1 << value);
                    break;
                case "remove" :
                    bit &= ~(1<<value);
                    break;
                case "check" :
                    sb.append((bit & (1 << value)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle" :
                    bit ^= (1<<value);
                    break;
                case "all" :
                    bit = (1<<20) - 1;
                    break;
                case "empty" :
                    bit = 0;
                    break;
            }

        }
        System.out.println(sb);
    }
}