public class lc724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for (int i=0; i<=n; i++){
            if (i == 0){
                pre[0] = 0;
                continue;
            }

            pre[i] = pre[i-1] + nums[i-1];
        }
        for (int p: pre){
            System.out.print(p + " ");
        }
        for (int i=0; i<=n; i++){
            if (pre[i] == pre[n] - pre[i]){
                return i;
            }
        }

        return -1;



    }
}
