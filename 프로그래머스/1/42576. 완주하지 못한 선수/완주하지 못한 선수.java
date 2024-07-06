import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();

        for (String c : completion) {
            if (map.containsKey(c)){
                map.replace(c, map.get(c) + 1);
                continue;
            }
            map.put(c,1);
        }
        String answer = "";
        for (String p : participant) {
            if (map.containsKey(p)) {
                if (map.get(p) == 1) {
                    map.remove(p);
                } else {
                    map.replace(p, map.get(p) - 1);
                }
            } else {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}