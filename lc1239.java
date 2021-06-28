package LC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1239 {
//    Map<Character, Integer> dic = new HashMap<>();
    int[] dic = new int[26];
    int res = 0;
    public int maxLength(List<String> arr) {
        int N = arr.size();

        BackTrace(arr, 0, 0);



        return res;

    }

    void BackTrace(List<String> arr, int index, int l){
        String str = arr.get(index);
        int N = str.length();
        int t = 0;


        for(int i=0; i<26; i++){
           if(dic[i] > 0){
               t++;
           }
        }  // 先前的长度
        res = Math.max(res, t);

        for(int i= index; i<arr.size(); i++){
            char[] s = arr.get(i).toCharArray();
            boolean repetition = false;
            for(int j=0; j<s.length; j++){
                if(dic[s[j]-'a'] != 0){
                    // 重复
                    repetition=true;
                    for(int k=j-1;k>=0;k--)
                    {
                        dic[s[k]-'a']--;
                    }
                    break;
                }
                dic[s[j] - 'a']++;
            }
            if(!repetition){
                continue;
            }

            BackTrace(arr, i+1, 0);

            // 复原
            for (char c : s) {
                dic[c - 'a']--;
            }

        }


    }

}
