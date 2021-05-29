package LC;

public class lc904 {
    public int totalFruit(int[] tree) {
        int N = tree.length;
        if(N==1) return 1;
        int left = 0, right = 1;
        int res = -1;
        while(left < N){
            int tmp = 1;
            while(right < N && tree[left] == tree[right]){
                left++;
                right++;
                tmp++;
            }
            if(right==N){
                res = Math.max(res, tmp);
                break;
            }

            int another = tree[right];
            while (right<N && (tree[right]==another || tree[left]==tree[right])){
                right++;
                tmp++;
            }
            res = Math.max(res, tmp);
            if(right==N){
                // System.out.println("2: " + tmp + " " + left + " " + right);
                break;
            }
            // System.out.println("3: " + tmp + " " + left + " " + right);
            left = left + 1;
            right = left + 1;


        }

        return res;
    }
}
