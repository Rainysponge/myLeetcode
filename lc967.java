package LC;

import java.util.ArrayList;
import java.util.List;

public class lc967 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<10; i++){
            dfs(res, n-1, k, 0, i);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    void dfs(List<Integer> res, int n, int k, int num, int i){
        if(i<0 || i>=10){
            return;
        }

        int tmp = num*10 + i;
        if(n == 0){
            res.add(tmp);
        }else{
            dfs(res, n-1, k, tmp, i-k);
            if(k != 0)
                dfs(res, n-1, k, tmp, i+k);
        }



    }
}
