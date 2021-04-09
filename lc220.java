package LC;

import java.util.HashMap;
import java.util.Map;

public class lc220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<0 && t<0){
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        long buckets_size = t + 1;
        for(int i=0;i<nums.length;i++){
            long buckets_num = nums[i] / buckets_size;
            if(buckets.containsKey(buckets_num)) return true;
            if(buckets.containsKey(buckets_num+1)&&abs(nums[i]-buckets.get(buckets_num+1))<=t){
                return true;
            }
            if(buckets.containsKey(buckets_num-1)&&abs(nums[i]-buckets.get(buckets_num-1))<=t){
                return true;
            }
            buckets.put(buckets_num, (long)nums[i]);

            if(i>=k){
                long tmp = nums[i-k]/buckets_size;
                buckets.remove(tmp);
            }
        }
        return false;

    }

    public long abs(long a){
        if(a<0) return -a; return a;

    }
}
