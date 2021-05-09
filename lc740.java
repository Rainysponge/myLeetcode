package LC;

public class lc740 {
    public int deleteAndEarn(int[] nums) {

        int maxVal = 0;
        for(int each: nums){
            maxVal = Math.max(each, maxVal);
        }
        int[] sum = new int[maxVal+1];
        for(int each: nums){
            sum[each] += each;
            // HASH排序
        }
        return Func(sum);
    }
    private int Func(int[] sum){
        if(sum.length<2) return sum[0];
        int first = sum[0], second = Math.max(first, sum[1]);
        for(int i=2; i < sum.length; i++){
            int tmp = second;  // 滚动数组
            second = Math.max(second, first+sum[i]);
            first = tmp;
        }
        return second;
    }

}
