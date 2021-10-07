package LC;

public class lc58 {
    public int lengthOfLastWord(String s) {
        char[] s1 = s.toCharArray();

        int l = s1.length;

        boolean f = false;
        int res = 0;

        for (int i=l-1; i>=0; i--){
            if(f){
                // 遇到过字母
                if(s1[i] == ' ') break;
                else res++;
            }else{
                // 未遇到字母
                if(s1[i] != ' '){
                    f = true;
                    res++;
                }

            }
        }
        return res;
    }
}
