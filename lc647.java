package LC;
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
public class lc647 {
    int res = 0;
    public int countSubstrings(String s) {
        res = s.length();
        if(res<=1) return res;
        char[] sChar = s.toCharArray();
        for(int i=1; i<s.length(); i++){
            sub(sChar, i);
        }



        return res;
    }

    private void sub(char[] sChar, int i){
        int l = i - 1;
        int r = i + 1;
        while(l>=0 && r < sChar.length){
            if(sChar[l]==sChar[r]){
                res++;
                l--;
                r++;
            }
            else{
                break;
            }
        }
        l = i-1; r = i;
        while (l>=0 && r < sChar.length){
            if(sChar[l]==sChar[r]){
                res++;
                l--;
                r++;
                continue;
            }
            break;
        }

    }
}
