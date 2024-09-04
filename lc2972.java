public class lc2972 {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 1, j = n - 2;
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        if (i == n) {
            return n * (n + 1) / 2;
        }
        i--;
        while (j >= 0 && nums[j] < nums[j + 1]) {
            j--;
        }
        j++;
        // 不带后缀，只保留前缀的可能性
        long ans = i + 2;
        System.out.println("ans:" + ans);
        // 双指针枚举，带后缀的情况
        for (int x = i, y = n - 1; y >= j; y--) {
            while (x >= 0 && nums[x] >= nums[y]) {
                x--;
            }
            ans += x + 2;
        }
        return ans;

    }
}
