class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int c1Idx=0, c2Idx=0;
        for (String g : goal) {
            if (cards1[c1Idx].equals(g)) {
                if (c1Idx + 1 < cards1.length) {
                    c1Idx++;
                }
            } else if (cards2[c2Idx].equals(g)) {
                if (c2Idx + 1 < cards2.length) {
                    c2Idx++;
                }
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}