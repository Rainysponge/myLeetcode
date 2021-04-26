package LC;

import java.util.*;

public class lc1681 {
    public int minimumIncompatibility(int[] nums, int k) {
        // 暴力
        Map<Integer, Integer> dic = new HashMap<>();
        Arrays.sort(nums);
        int res = 0;
        List<List<Integer>> bucket = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i<k){
                List<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                bucket.add(t);
            }else{
                int index = (i-1)/k;
                if(bucket.get(i%k).get(index)!=nums[i]) {
                    bucket.get(i % k).add(nums[i]);
                }else{
                    return -1;
                }
            }
        }
        for(int i=0; i<bucket.size(); i++){
            int t = 0;
            int last = bucket.get(i).size()-1;
            res += bucket.get(i).get(last) - bucket.get(i).get(0);

        }
        return res;
    }
}
