class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        return (s.matches("^[0-9]*$") && (s.length() == 4 || s.length() == 6));
    }
}