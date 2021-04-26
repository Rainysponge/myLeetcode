package LC;
//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//
//传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
// 我们装载的重量不会超过船的最大运载重量。
//
//返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
//


import java.util.Arrays;

public class lc1011 {
    public int shipWithinDays(int[] weights, int D) {
        int Sum = 0;
        for(int each: weights){
            Sum += each;
        }
        int low = 0, high = Sum;
        int mid = (low + high) / 2;
        while(low<high){
            if(Check(weights, D, mid)){
                // 可以，说明容量过大 向左边搜索
                high = mid;
            }else{
                // 容量过小
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }

        return low;



    }

    public boolean Check(int[] weight, int D, int capacity){
        int day = 0;
        int w = 0;
        int index = 0;
        int N = weight.length;
        while(index<N){
            if(weight[index] > capacity) return false;
            if(w+weight[index]>capacity){
                // System.out.println(w);
                day++;
                w = weight[index];

            } else{
                // System.out.println(w);
                w += weight[index];

            }
            index++;
        }
        System.out.println(w);
        if(w>0) day++;
        return day <= D;
    }

}
