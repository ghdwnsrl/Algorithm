class Solution {
    public int solution(int a, int b, int n) {
        return cola(a, b, n);
    }
    public static int cola(int a, int b, int n) {
        if (n < a)
            return 0;

        return ((n / a) * b) + cola(a,b,((n / a) * b) + (n % a));
    }
}