package LC;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组：[0,1,2,4,5,6,7] 可能变为：[4,5,6,7,0,1,2] 。
//请找出其中最小的元素。
//输入：nums = [3,4,5,1,2]
//输出：1

public class lc153 {
    public int findMin(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = (low+high) / 2;

        while(low<high){
            if(nums[mid]>nums[high]){
                low = mid + 1;
                mid = (low+high) / 2;
            }
            else{
                high = mid;
                mid = (low+high) / 2;
            }
        }
        return nums[mid];



    }
}
