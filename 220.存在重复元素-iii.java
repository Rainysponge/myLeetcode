/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            // if(k<0 && t<0){
            //     return false;
            // }

            // Map<Long, Long> buckets = new HashMap<>();
            // long buckets_size = t + 1;
            // for(int i=0;i<nums.length;i++){
            //     long buckets_num = nums[i] / buckets_size;
            //     if(buckets.containsKey(buckets_num)) return true;
            //     if(buckets.containsKey(buckets_num+1)&&abs(nums[i]-buckets.get(buckets_num+1))<=t){
            //         return true;
            //     }
            //     if(buckets.containsKey(buckets_num-1)&&abs(nums[i]-buckets.get(buckets_num-1))<=t){
            //         return true;
            //     }
            //     buckets.put(buckets_num, (long)nums[i]);

            //     if(i>=k){
            //         long tmp = nums[i-k]/buckets_size;
            //         buckets.remove(tmp);
            //     }
            // }
            // return false;
            if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }


    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }





    public long abs(long a){
        if(a<0) return -a; return a;

    }
}

// @lc code=end

