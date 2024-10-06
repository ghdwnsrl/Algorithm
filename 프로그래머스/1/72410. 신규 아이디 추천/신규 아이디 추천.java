import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9-_.]*","");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^\\.|\\.$", "");
        if (answer.isEmpty()) answer = "a";
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$","");
        }
        if (answer.length() < 3) {
            for (int i = answer.length(); i < 3; i++) {
                answer += answer.charAt(i-1);
            }
        }
        return answer;
    }
}