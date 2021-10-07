package LC;

import java.util.Arrays;

public class lc517 {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int N = machines.length;
        if(sum % N != 0){
            return -1;
        }


        for(int i=0; i<N; i++){
            machines[i] = machines[i] - sum / N;
        }

        int res = -1;
        for(int i=0; i<N-1; i++){
            res = Math.max(machines[i+1] , res);
            res = Math.max(Math.abs(machines[i]), res);
            machines[i+1] = machines[i+1] + machines[i];
        }
        return Math.max(res, machines[N-1]);




    }
}
