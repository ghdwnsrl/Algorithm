import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion) {
            int left = map.get(c);
            if(left == 1)
                map.remove(c);
            else 
                map.put(c, left - 1);
        }
        
        return map.entrySet().iterator().next().getKey();
    }
}