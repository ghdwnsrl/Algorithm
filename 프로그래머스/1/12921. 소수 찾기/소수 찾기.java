class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                continue;
            }
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        
        for(int i = 2; i < prime.length; i ++) {
            if(!prime[i])
                answer++;
        }
        
        return answer;
    }
}