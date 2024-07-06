class Solution {
    public String solution(int[] food) {
        String s = "";
        for (int i = 1; i < food.length; i++) {

            int value = food[i] / 2;
            for (int j = 0; j < value; j++) {
                s += i;
            }

        }
        s += 0;
        for (int i = food.length - 1;  i >= 1; i--) {

            int value = food[i] / 2;
            for (int j = 0; j < value; j++) {
                s += i;
            }

        }

        return s;

    }
}