package LC;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//给你两个长度可能不等的整数数组 nums1 和 nums2 。
// 两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
public class lc1775 {
    public int minOperations(int[] nums1, int[] nums2) {

        int sum1=0,sum2=0;
        for (int i = 0; i < nums1.length; i++) {
            sum1+=nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2+=nums2[i];
        }
        if(sum1==sum2)return 0;
        else if(sum1>sum2){
            return minOperations(nums2,nums1);
        }
        //sum1<sum2
        int diff=sum2-sum1;
        int res=0;
        int num[]=new int[6];
        for (int i = 0; i < nums1.length; i++) {
            num[6-nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            num[nums2[i]-1]++;
        }
        for (int i = 5; i >=1&&diff>0 ; i--) {
            while(num[i]>0&&diff>0){
                diff-=i;
                num[i]--;
                res++;
            }
        }
        return diff>0?-1:res;


    }

    private int OperationsMin(int[] minList, int sumMax, int sumMin){
        // minList为和更小的数组
        int N = minList.length;
        int res = 0;
//        int[] heap = new int[N+1];
//        heap[0] = 0;  // 哨兵
//        for(int i=1; i<=N; i++){
//
//        }
        Arrays.sort(minList);
        int sub = sumMax - sumMin;
        for(int i=0; i<N; i++){
            int t = 6 - minList[i];
            if(t == 0){
                break;
            }else if(t<sub){
                sub -= t;
                res++;
            }else{
                return res+1;
            }
        }

        if(sub==0) return res;
        return -1;

    }

//    private void Insert(int[] heap, int i, int[] nums){
//
//
//
//
//    }
    private int OperationsMax(int[] maxList, int sumMax, int sumMin){
    // minList为和更小的数组
        int N = maxList.length;
        int res = 0;


        Arrays.sort(maxList);
        int sub = sumMax - sumMin;
        for(int i=N-1; i>=0; i--){
            int t = maxList[i] - 1;
            if(t == 0){
                break;
            }else if(t<sub){
                sub -= t;
                res++;
            }else{
                return res+1;
            }
    }

    if(sub==0) return res;
    return -1;

}


}
