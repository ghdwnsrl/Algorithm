class Solution {
    public int solution(String t, String p) {
        
        Long pInt = Long.parseLong(p);
        int window = p.length();

        
        int count = 0;
        for (int i = 0; i <= t.length() - window; i++) {
            if (Long.parseLong(t.substring(i,i+window)) <= Long.parseLong(p)) {
                count++;
            }
        }
        
        return count;
    }
}