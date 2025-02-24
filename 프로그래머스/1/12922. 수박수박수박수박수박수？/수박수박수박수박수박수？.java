class Solution {
    public String solution(int n) {
        String[] pattern = {"수", "박"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) sb.append(pattern[0]);
            else sb.append(pattern[1]);
        }
        return sb.toString();
    }
}