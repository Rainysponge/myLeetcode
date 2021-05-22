package LC;

public class lc1784 {
    public boolean checkOnesSegment(String s) {
        char[] s1 = s.toCharArray();
        int N = s1.length;
        int res = 0;
//        boolean flag = false
        if(s1[0] == '1') {
            res++;
//            flag = true;
        }
        for(int i=1; i<N; i++){
            if(s1[i-1] == '0'){
                if(s1[i] == '1'){
                    res++;
                }
            }
        }

        return res <= 1;
    }
}
