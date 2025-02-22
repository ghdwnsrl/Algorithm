class Solution {
    public int solution(int n) {
        String base3 = Integer.toString(n, 3);
        return Integer.parseInt(new StringBuilder(base3).reverse().toString(), 3);
    }
}