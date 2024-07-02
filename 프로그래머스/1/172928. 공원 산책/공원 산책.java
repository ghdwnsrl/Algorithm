class Solution {
    static int parkX, parkY ;
    static Character[][] parkArr;
    
    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;

        parkArr = new Character[park.length][park[0].length()];
        parkY = park[0].length();
        parkX = park.length;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
                parkArr[i][j] = park[i].charAt(j);
            }
        }
        for (int i = 0; i < routes.length; i++) {
            boolean isWall = false;
            String[] result = routes[i].split(" ");
            String op = result[0];
            Integer N = Integer.parseInt(result[1]);

            switch (op) {
                case "E":
                    if (checkMove(x, y + N)) {
                        for (int j = y; j <= y + N; j++) {
                            if (parkArr[x][j] == 'X'){
                                isWall = true;
                                break;
                            }
                        }
                        if (isWall) break;
                        y += N;
                    }
                    break;
                case "W":
                    if (checkMove(x, y - N)) {
                        for (int j = y - N; j <= y; j++) {
                            if (parkArr[x][j] == 'X'){
                                isWall = true;
                                break;
                            }
                        }
                        if (isWall) break;
                        y -= N;
                    }
                    break;
                case "S":
                    if (checkMove(x + N, y)) {
                        for (int j = x; j <= x + N; j++) {
                            if (parkArr[j][y] == 'X'){
                                isWall = true;
                                break;
                            }
                        }
                        if (isWall) break;
                        x += N;
                    }
                    break;
                case "N":
                    if (checkMove(x - N, y)) {
                        for (int j = x - N; j <= x ; j++) {
                            if (parkArr[j][y] == 'X'){
                                isWall = true;
                                break;
                            }
                        }
                        if (isWall) break;
                        x -= N;
                    }
                    break;
            }

        }

        return new int[]{x,y};
    }

    public static boolean checkMove(int x, int y) {
        return x < parkX && y < parkY && y >= 0 && x >= 0;
    }
}