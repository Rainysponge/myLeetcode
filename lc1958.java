public class lc1958 {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
        for(int[] move: moves){
            if (help(board, move[0], move[1], rMove, cMove, color)){
                return true;
            }
        }
        return false;
    }

    boolean help(char[][] board, int dx, int dy, int rMove, int cMove, char color){
        int x = rMove + dx;
        int y = cMove +dy;
        int step = 1; // 第一步

        while(x < 8 && x >= 0 && y < 8 && y>=0){
            if (step == 1){
                if (board[x][y] == color|| board[x][y] == '.'){
                    return false;
                }
            } else {
                if (board[x][y] == '.'){
                    return false;
                }

                if (board[x][y] == color){
                    return true;
                }
            }


            x = x + dx;
            y = y +dy;
            step++;

        }

        return false;

    }


}
