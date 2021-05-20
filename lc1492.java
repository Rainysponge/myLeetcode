package LC;

import java.util.HashMap;
import java.util.Map;

public class lc1492 {
    public int kthFactor(int n, int k) {
        Map<Integer, Integer> dic = new HashMap<>();
        double s = Math.sqrt((double) n);
        dic.put(1, n);
        int count = 1;
        for(int i=2; i<=(int)s; i++){
            if(n % i == 0){
                count++;
                if(count==k){
                    return i;
                }

                dic.put(count, n / i);

            }
        }

        return dic.getOrDefault(k-count, -1);




    }
}
