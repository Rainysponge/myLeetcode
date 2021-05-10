package LC;

import java.util.ArrayList;
import java.util.List;

public class lc763 {
    public List<Integer> partitionLabels(String s) {
        char[] s1 = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        if(s1.length == 1) {
            res.add(1);
            return res;
        }
        int left = 0, right = s1.length - 1;
        int end = s1.length - 1;
        int begin = 0;
        while(left < s1.length){
            while(s1[begin]!=s1[end]){
                end--;
            }
            int t;
            while (left<end){
                t = right;
                left++;
                for(; t > end; t--){
                    if(s1[left]==s1[t]){
                        end = t;
                        break;
                    }
                }

            }
            res.add(end - begin);
            begin = end + 1;
            left = end + 1;
            end = right;

        }
        return res;

    }
}
