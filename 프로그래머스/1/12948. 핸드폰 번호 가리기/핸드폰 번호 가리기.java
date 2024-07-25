class Solution {
    public String solution(String phone_number) {
        int idx = phone_number.length() - 4;
        String substring = phone_number.substring(idx);
        String answer = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        answer = answer + substring;

        return answer;
    }
}