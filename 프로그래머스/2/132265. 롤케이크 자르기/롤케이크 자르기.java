import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int t : topping) {
            map2.put(t, map2.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);

            if (map2.get(t) - 1 == 0)
                map2.remove(t);
            else
                map2.put(t, map2.get(t) - 1);

            if (map2.size() == map.size())
                result++;
        }
        return result;
    }
}