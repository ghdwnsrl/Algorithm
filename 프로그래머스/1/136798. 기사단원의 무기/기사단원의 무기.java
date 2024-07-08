class Solution {
    public int solution(int number, int limit, int power) {
        int[] members = new int[number];

        for (int i = 1; i <= number; i++) {

            double sqrt = Math.sqrt(i);
            int count = 0;
            for (int j = 1; j < sqrt; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (i % sqrt == 0) {
                count = 2* count + 1 ;
            } else {
                count *= 2;
            }
            members[i-1] = count;
        }

        int answer = 0;
        for (int member : members) {
            if (member > limit) {
                answer += power;
                continue;
            }
            answer += member;
        }
        return answer;
    }
}