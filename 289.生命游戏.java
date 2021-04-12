/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length==0 || board[0].length==0){
            return;
        }
        int[][] move = new int[][]{{1,1}, {1,0}, {1,-1},
                                    {0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int count = 0;
                for(int[] step: move){
                    if(InBoard(step, i, j, board)){
                        if(board[i+step[0]][j+step[1]] == 1 || board[i+step[0]][j+step[1]] == 2){
                            count++;
                            // 0 不变0 1 不变1 2 1-》0 3 0-》1
                        }
                    }
                }
                if(count>3){
                    if(board[i][j]==1) board[i][j] = 2;
                }else  if(count==3){
                    if(board[i][j]==0) board[i][j] = 3;
                }else if(count < 2){
                    if(board[i][j]==1) board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==2) board[i][j] = 0;
                else if(board[i][j]==3) board[i][j] = 1;
                // System.out.printf("%d\t", board[i][j]);
            }
            // System.out.println("");
        }
    }
    public boolean InBoard(int[] move, int i, int j, int[][] board){
        return i + move[0] >= 0 && i + move[0] < board.length && j + move[1] >= 0 && j + move[1] < board[0].length;
    }
}
// @lc code=end

