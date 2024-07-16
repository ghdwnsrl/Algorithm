class Solution {
    public int solution(int[][] sizes) {
        
        int w = sizes[0][0];
        int h = sizes[0][1];

        for (int[] size : sizes) {

            int cmp = Math.abs((w - size[0])) + Math.abs((h - size[1]));
            int cmpR = Math.abs((w - size[1])) + Math.abs(h - size[0]);

            if ( cmp <= cmpR) {
                w = Math.max(size[0], w);
                h = Math.max(size[1], h);
            } else {
                w = Math.max(size[1], w);
                h = Math.max(size[0], h);
            }
        }
        
        
        return w*h;
    }
}