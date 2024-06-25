class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        int[] answer = {};

        answer = new int[numbers.length];
        
        int first = 0;
        int last = numbers.length - 1;
        
        int tmp;
        
        if (direction.equals("right")) {
            answer[first] = numbers[last];
            for(int i = 0; i < numbers.length - 1; i ++) {
                answer[i + 1] = numbers[i];
            }
        } else {
            answer[last] = numbers[first];
            for(int i = 0; i < numbers.length - 1; i ++) {
                answer[i] = numbers[i + 1];
            }
        }
        return answer;
    }
}