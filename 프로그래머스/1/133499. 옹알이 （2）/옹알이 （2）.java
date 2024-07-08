import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        Set<String> set = new HashSet<>();
        
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        

        int answer = 0;
        
        for (String b : babbling) {
            String cmp = "";
            String before = "";
            System.out.println(b+ " start");
            for (int i = 0; i < b.length(); i++) {
                cmp += b.charAt(i);
                if (set.contains(cmp)) {
                    if (before.equals(cmp)) {
                        continue;
                    }
                    before = cmp;
                    System.out.println(cmp);
                    cmp = "";
                }
            }
            if (cmp.equals("")){
                answer ++;
            }
        }
        return answer;
    }
}