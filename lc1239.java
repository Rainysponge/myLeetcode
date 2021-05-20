package LC;

import java.util.List;

public class lc1239 {
    int res = -1;

    public int maxLength(List<String> arr) {
        // System.out.println('b' - 'a');
        int[] dic = new int[26];
        dfs(arr, dic, 0);
        return res;
    }

    void dfs(List<String> arr, int[] dic, int start){
        int tmp = 0;  // 记录长度
        for(int i=0; i<26; i++){
            if(dic[i] != 0){
                tmp++;  // 算出当前长度
            }
        }
        res = Math.max(res, tmp);
        for(int i=start; i<arr.size(); i++){
            char[] s = arr.get(i).toCharArray();
            boolean flag = true;  // 记录是否冲突
            for(int j=0; j<s.length; j++){
                if(dic[s[j]-'a'] != 0){
                    // 重复
                    flag=false;
                    for(int k=j-1;k>=0;k--)
                    {
                        dic[s[k]-'a']--;
                    }
                    break;
                }
                dic[s[j] - 'a']++;
            }
            if(!flag){
                continue;
            }

            dfs(arr, dic, start+1);

            // 复原
            for (char c : s) {
                dic[c - 'a']--;
            }


        }


    }


}
