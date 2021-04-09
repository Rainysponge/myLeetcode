package LC;

public class lc80 {
    public int removeDuplicates(int[] nums) {
        int numLength = nums.length;
        if (numLength < 3){
            return numLength;
        }
        int index = 1;
        int pre = nums[1];
        int cap = (nums[0] == nums[1])?0:1;

        for(int i=0;i<numLength;i++){
            if(nums[i]==pre && cap>0){
                nums[index] = nums[i];

                cap--;
                index++;
                continue;
            }
            if(nums[i]!=pre){
                cap = 1;
                nums[index] = nums[i];
                index++;
                pre = nums[i];


            }
        }
        return index;


    }
}
