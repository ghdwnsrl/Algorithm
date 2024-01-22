import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int tmp = 1;

        for (int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '(') {
                stack.push(N.charAt(i));
                tmp *= 2; //( : 2
            } else if(N.charAt(i) == '[') {
                stack.push(N.charAt(i));
                tmp *= 3; //[ : 3
            } else if (N.charAt(i) == ')') {

                if (stack.empty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                } else if (N.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
            }else if (N.charAt(i) == ']') {

                if (stack.empty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                } else if (N.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        if(!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(answer).append("\n");
        System.out.print(sb);
    }
}
