class Solution {
    public String solution(String s) {
        
        String[] arr = s.split("");
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (String ar : arr) {
            cnt = ar.equals(" ") ? 0 : cnt + 1;
            sb.append(cnt % 2 == 0 ? ar.toLowerCase() : ar.toUpperCase());
        }
        return sb.toString();
    }
}