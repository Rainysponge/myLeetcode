package LC;

public class lc1822 {
    public int arraySign(int[] nums) {
        boolean flag = false;
        for(int each: nums){
            if(each==0){
                return 0;
            }else if(each<0){
                flag = !flag;
            }
        }
        return flag ? -1 : 1;
    }
}
