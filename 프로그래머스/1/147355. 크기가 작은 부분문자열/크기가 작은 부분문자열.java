class Solution {
    public int solution(String t, String p) {
        
        Long pInt = Long.parseLong(p);
        int window = p.length();


        int count = 0;
        for (int i = 0; i <= t.length() - window; i++) {

            String ans = "";
            for (int j = i; j < i + window; j++) {
                ans += t.charAt(j);
            }

            long cmp = Long.parseLong(ans);
            if (cmp <= pInt) {
                count ++;
            }
        }
        
        return count;
    }
}