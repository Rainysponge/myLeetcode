package LC;
//给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
//
//返回使字符串任意相邻两个字母不相同的最小删除成本。
//
//请注意，删除一个字符后，删除其他字符的成本不会改变。

public class lc1578 {
    public int minCost(String s, int[] cost) {
        // greedy
        int sLen = s.length();
        char[] s1 = s.toCharArray();
        int index = 0;
        int res = 0;
        for(int i=1; i<sLen; i++){
            if(s1[index]==s1[i]){
                index = i;
            }else{
                if(cost[index]>cost[i]){
                    res += cost[i];
                }else{
                    res += cost[index];
                    index = i;
                }
            }
        }

        return res;
    }
}
