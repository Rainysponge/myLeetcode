package LC;

public class lc162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 贪心二分，如果上升则右侧必有峰
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] < nums[mid-1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;

    }
}
