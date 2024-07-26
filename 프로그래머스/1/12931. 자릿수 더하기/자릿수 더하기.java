import java.util.*;

public class Solution {
    public int solution(int n) {
        
        String strN = String.valueOf(n);
        int answer = 0;
        
        for (int i = 0; i < strN.length(); i++) {
            answer += strN.charAt(i) - '0';
        }
        return answer;
    }
}