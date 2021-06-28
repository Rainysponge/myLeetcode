package LC;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class lc909 {
    int N = 0;
    boolean[] visited;
    int res = 0;
    public int snakesAndLadders(int[][] board) {
        N = board.length;
        visited = new boolean[N*N+1];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int i=1; i<=6; i++){
                int next = p[0] + i;
                if(next > N*N){
                    break;

                }
                int[] x = GetLocation(next);
                if(board[x[0]][x[1]] > 0){
                    next = board[x[0]][x[1]];
                }
                if(next == N*N){
                    return p[1] + 1;
                }

                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next, p[1]+1});
                }
            }
        }
        return -1;
    }



    int[] GetLocation(int cur){
        int row = N - 1 - (cur-1) / N;
        int col = (N-row) % 2 == 1 ? (cur-1) % N : N - (cur-1) % N - 1;
        return new int[]{row, col};
    }


}
