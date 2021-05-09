package LC;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lc135 {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] resList = new int[N];
        for(int i=0; i<N; i++){
            resList[i] = 1;
        }
        for(int i=0; i<N-1; i++){
            if(ratings[i] < ratings[i+1]){
                resList[i+1] = resList[i] + 1;
            }

        }
        for(int i=N-1; i>0; i--){
            if(ratings[i]<ratings[i-1]){
                resList[i-1] = Math.max(resList[i]+1, resList[i-1]);
            }

        }
        for(int a: resList){
            System.out.println(a);
        }
        return Arrays.stream(resList).sum();
    }
}
