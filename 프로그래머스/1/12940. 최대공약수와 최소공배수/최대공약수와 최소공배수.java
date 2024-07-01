class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int small = Math.min(n,m);
        int big = Math.max(n,m);

        answer[0] = gcd(small,big);
        answer[1] = (small * big) / gcd(small,big);
        
        return answer;
    }

    private static int gcd(int small, int big) {
        if (big % small == 0) {
            System.out.println(small);
            return small;
        }
        return gcd(big % small, small);
    }
}