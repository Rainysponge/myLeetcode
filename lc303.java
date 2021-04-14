package LC;

public class lc303 {
    int[] nums;
    int[] sums;
    boolean[] used;
    public lc303(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        this.used = new boolean[nums.length];


    }

    public int sumRange(int left, int right) {
//        int a = numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//        int b = numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
//        int c = numArray.sumRange(0, 5);
        int res=0;
        if(left==0){
            used[left] = true;
            sums[left] = nums[0];
            if(used[right]){
                return sums[right];
            }else{
                used[right] = true;
                for(int i=0 ; i<=right; i++){
                    res += nums[i];
                }
                sums[right] = res;
                return res;
            }
        }
        //left>0

        if(!used[left-1]){
            used[left-1] = true;
            for(int i=0 ; i<left; i++){
                res += nums[i];
            }
            sums[left-1] = res;
        }
        if(!used[right]) {
            res = 0;
            used[right] = true;

            for(int i=0 ; i<=right; i++){
                res += nums[i];
            }

            sums[right] = res;
        }

        return sums[right] - sums[left-1];


    }

    public void printNum(){
        System.out.println("");
        for(int i=0; i<this.sums.length; i++){
            System.out.printf("%d\t", nums[i]);
        }
        System.out.println("");
        for (int sum : this.sums) {
            System.out.printf("%d\t", sum);
        }
        System.out.println("");
        for(int i=0; i<this.sums.length; i++){
            System.out.print(used[i] + "\t");
        }
        System.out.println("");

    }
}
