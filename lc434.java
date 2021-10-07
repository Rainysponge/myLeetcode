package LC;

public class lc434 {
    public int countSegments(String s) {
        char[] s1 = s.toCharArray();
        int N = s1.length;
        int res = 0;
        boolean flag = false;  // 是否遇到过非空格
        for(int i = 0; i < N; i++){
            if(s1[i] == ' '){
                if(flag){
                    res++;
                    flag = false;
                }
            }else{
                flag = true;
                if(i == N - 1){
                    res++;
                }
            }
        }
        return res;

    }
}
