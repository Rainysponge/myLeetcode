package LC;

public class lc1446 {
    public int maxPower(String s) {
        int N = s.length();
//        char[] s1 = s.toCharArray();
        int res = 1, t = 1;
        for(int i=1; i<N; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                t++;
                res = Math.max(res, t);
            }else{
                t = 1;
            }
        }
        return res;
    }
}
