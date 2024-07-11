import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        
        List<String> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            if (map.containsKey(X.charAt(i))) {
                map.replace(c, map.get(c) + 1);
                continue;
            }
            map.put(c,1);
        }

        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            if (map.containsKey(Y.charAt(i))) {
                if (map.get(c) == 0) {
                    map.remove(c);
                    continue;
                }
                list.add(String.valueOf(c));
                map.replace(c, map.get(c) - 1);
            }
        }

        String answer = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());
        
        if(answer.isEmpty()) return "-1";
        if(answer.replaceAll("0", "").isEmpty()) return "0";
        return answer;
    }
}