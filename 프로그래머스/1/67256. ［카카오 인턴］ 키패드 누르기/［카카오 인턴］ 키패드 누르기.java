class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int curL = 10;
        int curR = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                curL = number;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                curR = number;
            } else {
                if ( number == 0) {
                    number = 11;
                }
                int absL = (Math.abs(curL - number) / 3 ) + (Math.abs(curL - number) % 3 );
                int absR = (Math.abs(curR - number) / 3 ) + (Math.abs(curR - number) % 3 );

                if ( absL == absR ) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        curL = number;
                    } else if (hand.equals("right")) {
                        sb.append("R");
                        curR = number;
                    }
                    continue;
                }

                if (absL < absR) {
                    sb.append("L");
                    curL = number;
                } else if (absL > absR) {
                    sb.append("R");
                    curR = number;
                }
            }
        }
        return sb.toString();
    }
}