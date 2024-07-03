import static java.lang.Integer.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = MAX_VALUE, minY = MAX_VALUE, maxX = MIN_VALUE, maxY = MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        return new int[]{minX, minY, maxX + 1, maxY + 1}; 

    }
}