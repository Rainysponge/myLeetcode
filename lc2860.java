import java.util.Collections;
import java.util.List;

public class lc2860 {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int res = 0;
        int n = nums.size();
        for (int i=0; i<=n; i++){
            if (i>0 && nums.get(i-1)>=i){
                continue;
            }
            if (i<n && nums.get(i) <= i){
                continue;
            }
            res++;

        }
        return res;
    }
}
