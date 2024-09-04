import java.util.Arrays;

public class lc2740 {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;

        for (int i=0; i<n-1; i++){
            int tmp_delta = nums[i+1] - nums[i];
            delta = Math.min(tmp_delta, delta);
        }

        return delta;
    }
}
