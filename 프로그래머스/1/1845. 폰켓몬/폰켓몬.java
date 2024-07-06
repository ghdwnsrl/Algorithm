import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> monster = new HashSet<>();
        int can = nums.length / 2;

        for (int num : nums) {
            monster.add(num);
        }

        if (monster.size() < can) {
            return monster.size();
        } else {
            return can;
        }
    }
}