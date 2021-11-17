package LC;

// import java.util.ArrayList;
// import java.util.List;

public class lc318 {
    public int maxProduct(String[] words) {
        int N = words.length;
        int[] map = new int[N];
        for(int i=0; i<N; i++){
            String tmp = words[i];
            int l = tmp.length();
            for(int j=0; j<l; j++){
                map[i] |= 1 << (tmp.charAt(j) - 'a');
                // 用或运算来更新map
            }
        }

        int res = 0;
        for(int i=0; i<N-1; i++){
            int l1 = words[i].length();
            for(int j=i+1; j<N; j++){
                if((map[i] & map[j]) == 0){
                    res = Math.max(res, l1 * words[j].length());
                }
            }
        }


        return res;
    }

}
