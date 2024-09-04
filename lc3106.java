public class lc3106 {
    public String getSmallestString(String s, int k) {
//         尽量让其变为a
        char[] s_list = s.toCharArray();
        int n = s.length();
        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            int dis_a = Math.min(c-'a', 'z'-c+1);
            if (dis_a < k){
                s_list[i] = 'a';
                k -= dis_a;
            }else if (dis_a == k){
                s_list[i] = 'a';
                break;
            }else{
                s_list[i] -= k;
                break;
            }
        }
        return new String(s_list);
    }
}
