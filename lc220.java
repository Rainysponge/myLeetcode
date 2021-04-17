package LC;
//给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在两个下标 i 和 j，
// 使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
//
//如果存在则返回 true，不存在返回 false。


import java.util.HashMap;

public class lc220 {
    long w; // 桶深
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 桶排序  我忘记了
        if(nums.length == 0 || t < 0)        return false;

        HashMap<Long, Long> map = new HashMap<>();
        w = (long)t + 1;

        for(int i=0; i<nums.length; i++){
            if(i-k-1>=0 && map.containsKey(getID(nums[i-k-1])))
                map.remove(getID(nums[i-k-1]));
            if(map.containsKey(getID(nums[i]))) return true;
            if(map.containsKey(getID(nums[i]) - 1)
                    && Math.abs(map.get(getID(nums[i]) - 1) - (long)nums[i]) <= t)
                return true;
            if(map.containsKey(getID(nums[i]) + 1)
                    && Math.abs(map.get(getID(nums[i]) + 1) - (long)nums[i]) <= t)
                return true;
            map.put(getID(nums[i]), (long)nums[i]);

        }
        return false;


    }
    private long getID(long num){
        if(num>=0) return num / w;
        return (num + 1)/ w - 1;  // 对负数先右移 -6 ——> -5 再把id左移 0 ——> -1
    }
}
