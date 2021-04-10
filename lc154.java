package LC;

public class lc154 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int mid = (low+high) / 2;

        while(low<high){
            if(nums[mid]>nums[high]){
                low = mid + 1;
                mid = (low+high) / 2;
            }
            else if(nums[mid]==nums[high]){
                if(nums[mid]>nums[low]){
                    high = mid;
                } else if(nums[mid]==nums[low]){
                   high -= 1;
                   low += 1;
                } else{
                    low = mid + 1;
                }
                mid = (low+high) / 2;
            }
            else{
                high = mid;
                mid = (low+high) / 2;
            }
//            else if(nums[mid]==nums[high]){
//
//            }
        }
        System.out.println(mid);
        return nums[mid];



    }
}
