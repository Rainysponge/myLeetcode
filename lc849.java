package LC;

public class lc849 {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] res = new int[N];
        res[0] = Integer.MAX_VALUE / 2;
        int d = 0;
        for(int i=1; i<N; i++){
            if(seats[i] == 1){
                res[i] = Integer.MAX_VALUE;
            }else{
                if(res[i-1] == Integer.MAX_VALUE){
                    res[i] = 1;
                }else{
                    res[i] = res[i-1] + 1;
                }
            }
        }
        for(int i=N-2; i>=0; i--){
            if(seats[i] != 1){
                if(res[i+1] == Integer.MAX_VALUE){
                    res[i] = 1;
                }else{
                    res[i] =  Math.min(res[i], res[i+1] + 1);
                }
            }
        }
        int t = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            if(seats[i] == 1) continue;
            t = Math.max(t, res[i]);
        }
        for(int i=0; i<N; i++){
            System.out.println(res[i]);
        }
        return t;

    }
}
