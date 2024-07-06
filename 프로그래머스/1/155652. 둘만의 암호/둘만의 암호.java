import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        HashSet<Character> set = new HashSet();

        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 1;
            while (count <= index) {
                char nextChar = (char) ((c + 1 - 'a') % 26 + 'a');
                if (set.contains(nextChar)) {
                    c = nextChar;
                    continue;
                }
                c = nextChar;
                count++;
            }
            answer += c;
        }
        return answer;
    }
}