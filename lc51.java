package LC;
import java.util.*;
public class lc51 {
    String[][] board;
    List<List<String>> res = new ArrayList<>();
    int N;
    public List<List<String>> solveNQueens(int n) {
        board = new String[n][n];
        N = n;
        //
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //Init
                board[i][j] = ".";
            }
        }
        backTrace(0);


        return res;
    }

    boolean isAvailable(int i, int j){
        // 行
        for(int t=j; t>=0; t--){
            if(board[i][t].equals("Q")) return false;
        }

        for(int t=i; t>=0; t--){
            if(board[t][j].equals("Q")) return false;
        }

        int min = Math.min(i, j);
        for(int t = 1; t<=min; t++){
            if(board[i-t][j-t].equals("Q")) return false;
        }

        min  = Math.min(i, N-j);
        for(int t = 1; t<=min; t++){
            if(board[i-t][j+t].equals("Q")) return false;
        }

        return true;

    }


    void backTrace(int i){
        if(i==N){
            List<String> t = new ArrayList<>();
            for(String[] row: board){
                StringBuffer sb = new StringBuffer();
                for(String c: row){
                    sb.append(c);
                }
                t.add(sb.toString());
            }
            res.add(t);
            return;
        }
        for(int t=0; t<N; t++){
            if(isAvailable(i, t)){
                board[i][t] = "Q";
                backTrace(i+1);
            }
            board[i][t] = ".";
        }
    }
}
