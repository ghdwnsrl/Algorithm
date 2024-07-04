import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    
    public static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }


    public int solution(String[] board) {
        Point start = null, goal = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j)=='R') {
                    start = new Point(i, j, 0);
                }
                if (board[i].charAt(j)=='G') {
                    goal = new Point(i, j, 0);
                }
            }
        }

        return bfs(board.length, board[0].length(),start,goal, board);


    }

    private static int bfs(Integer x, Integer y, Point start, Point goal,String[] board) {
        Queue<Point> queue = new LinkedList<>();

        boolean[][] visited = new boolean[x][y];

        visited[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            Point cur = queue.poll();

            if (cur.x == goal.x && cur.y == goal.y) {
                return cur.depth;
            }

            for (int i = 0; i < 4; i++) {
                int newX = cur.x;
                int newY = cur.y;

                while (newX >= 0 && newY >= 0 && newX < x && newY < y && board[newX].charAt(newY) != 'D') {
                    newX += dx[i];
                    newY += dy[i];
                }

                newX -= dx[i];
                newY -= dy[i];

                if (visited[newX][newY] || (cur.x == newX && cur.y == newY) )
                    continue;

                visited[newX][newY] = true;
                queue.add(new Point(newX,newY, cur.depth + 1));
            }

        }

        return -1;
    }
}