package LC;

import java.util.Arrays;

public class lc79 {
    boolean[][] visited;
    int m, n, l;
    boolean res = false;
    char[] s;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];


        s = word.toCharArray();
        l = s.length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(0, i, j, board);
            }
        }

        return res;



    }

    void dfs(int index, int i, int j, char[][] board){
        if(index == l){
            res = true;
            return;
        }
        if(i < 0 || i >= m || j < 0 || j >= n || res || visited[i][j]){

            return;
        }

        visited[i][j] = true;
//        System.out.println(i + " " + j);
        if(board[i][j] == s[index]){
//            System.out.println(i + " " + j + " " + s[index]);
            dfs(index+1, i+1, j, board);
            dfs(index+1, i-1, j, board);
            dfs(index+1, i, j+1, board);
            dfs(index+1, i, j-1, board);
        }

        visited[i][j] = false;


    }

}
