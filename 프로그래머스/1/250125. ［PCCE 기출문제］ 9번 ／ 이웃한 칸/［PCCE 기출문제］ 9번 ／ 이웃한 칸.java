import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static String[][] board;
    
    public int solution(String[][] board, int h, int w) {
        String find = board[h][w];
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];
            if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
                continue;
            }
            if (board[x][y].equals(find)) {
                answer++;
            }
        }
        
        return answer;
    }
}