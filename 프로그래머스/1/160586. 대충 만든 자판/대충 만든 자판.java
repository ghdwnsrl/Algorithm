
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        Map<Character, Integer> map = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {

                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), i + 1);
                    continue;
                }

                map.replace(s.charAt(i), Math.min(map.get(s.charAt(i)), i + 1));

            }
        }

        List<Integer> list = new ArrayList<>();
        
        for (String target : targets) {
            int result = 0;
            for (int i = 0; i < target.length(); i++) {
                if (!map.containsKey(target.charAt(i))) {
                    result = -1;
                    break;
                }
                result += map.get(target.charAt(i));
            }
            list.add(result);
        }
        
        return list
            .stream()
            .mapToInt(Integer::intValue)
            .toArray(); 
    }
}