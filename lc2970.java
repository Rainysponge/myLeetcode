

public class lc2970 {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int res = 0;
        int l = 1;
        while (l < n && nums[l - 1] < nums[l]) {
            l++;
        }
        res += l + (l < n ? 1 : 0);
        for (int r = n - 2; r >= 0; r--) {
            while (l > 0 && nums[l - 1] >= nums[r + 1]) {
                l--;
            }
            res += l + (l <= r ? 1 : 0);
            if (nums[r] >= nums[r + 1]) {
                break;
            }
        }
        return res;
    }
}
