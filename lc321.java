package LC;

//给定长度分别为m和n的两个数组，其元素由0-9构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
//
//求满足该条件的最大数。结果返回一个表示该最大数的长度为k的数组。
//
//说明: 请尽可能地优化你算法的时间和空间复杂度。


import java.util.Deque;
import java.util.LinkedList;

public class lc321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //二维
        int[] res = new int[k];
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        Deque<Integer> deque1 = new LinkedList<Integer>();
        Deque<Integer> deque2 = new LinkedList<Integer>();
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i+j==k){
                    deque1 = maxStack(nums1, i);
                    deque2 = maxStack(nums2, j);
//                    if(!deque1.isEmpty()) System.out.println(1 + deque1.poll());
//                    stackPrint(deque1, deque2, i, j);
//                    System.out.println("\n"+ merge(deque1,deque2));
                    int[] tmp = merge(deque1,deque2, k);
                    if(compare(res, tmp, k)<0){
                        res = tmp;
                    }
                }

            }
        }
//        int[] ans = new int[k];
//        for(int i=k-1;i>=0;i--){
//            ans[i] = res % 10;
//            res = res / 10;
//        }
        for(int i=0;i<k;i++){
            System.out.print(res[i]+"\t");
        }

        return res;

    }
    private void stackPrint(Deque<Integer> deque1, Deque<Integer> deque2, int i, int j){
        System.out.println(i+" " + j+"d1:\n");
        while(!deque1.isEmpty()){
            System.out.print(deque1.poll()+"\t");
        }
        System.out.println("");
        System.out.println("d2:");
        while(!deque2.isEmpty()){
            System.out.print(deque2.poll()+"\t");
        }
        System.out.println("");
    }


    public Deque<Integer> maxStack(int[] nums1, int k){
        Deque<Integer> res = new LinkedList<Integer>();
        int delete = nums1.length - k;
        for (int t : nums1) {
            while (!res.isEmpty() && delete > 0 && res.peekLast() < t) {
                res.pollLast();
                delete--;
            }
            res.offerLast(t);
        }
        while (delete > 0){
            res.pollLast();
            delete--;
        }
        return res;



    }

    public int[] merge(Deque<Integer> deque1, Deque<Integer> deque2, int k){
//        int[] res = new int[k];
        int[] subsequence1 = new int[deque1.size()];
        int[] subsequence2 = new int[deque2.size()];
        int i = 0, m = deque1.size(), n = deque2.size();
        for(i=0;i<m;i++){
            subsequence1[i] = deque1.poll();
        }
        for(i=0;i<n;i++){
            subsequence2[i] = deque2.poll();
        }

        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;









    }
    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    public int compare(int[] a, int[] b, int k){
        for(int i=0; i<k; i++){
            if(a[i]-b[i]!=0){
                return a[i] - b[i];
            }
        }
        return 0;
    }

}
