package LC;

import java.util.*;

public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 暴力 47/60 abab ab过不了
//        int sLen = s.length();
//        int pLen = p.length();
//        int index = 0;
//        List<Integer> res = new ArrayList<>();
//        Map<Character, Integer> dic = new HashMap<>();
//        for(int j=0; j<pLen; j++){
//            dic.put(p.charAt(j), dic.getOrDefault(p.charAt(j),0)+1);
//        }
//        int f = 0;
//        while(index<sLen){
//            char cs = s.charAt(index);
//            if(dic.containsKey(cs)&&dic.get(cs)>0){
//                f++;
//                dic.put(cs, dic.get(cs)-1);
//                System.out.println(index+" ");
//            }else{
//                dic.clear();
//                for(int j=0; j<pLen; j++){
//                    dic.put(p.charAt(j), dic.getOrDefault(p.charAt(j),0)+1);
//                }
//                f = 0;
//                if(dic.containsKey(cs)&&dic.get(cs)>0){
//                    f++;
//                    dic.put(cs, dic.get(cs)-1);
//                    System.out.println(index+" ");
//                }
//            }
//            index++;
//            if(f == pLen){
//                res.add(index-pLen);
//            }
//        }
//
//        return res;

        // slide window 暴力
        int start = 0, left = 0, right= 0;
        int match = 0;

        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs  = new HashMap<>();

        for(char c : p.toCharArray())
            needs.put(c, needs.getOrDefault(c, 0) + 1);

        while(right < s.length())
        {
            //---------rp to move-------------------
            char c1 = s.charAt(right);
            if(needs.containsKey(c1))
            {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if(window.get(c1).equals(needs.get(c1)))
                    match++;
            }
            else
            {
                left = right+1;
                window = new HashMap<>();
                match = 0;
            }
            right++;
            //---------rp to move-------------------


            while(match == needs.size())
            {
                start = left;
                if(window.equals(needs))    res.add(start);

                char c2 = s.charAt(left);
                if(window.containsKey(c2))
                {
                    window.put(c2, window.get(c2) - 1);
                    if(window.get(c2) < (needs.get(c2)))
                        match--;
                }

                left++;
            }
        }
        return res;





    }

    private  void InitDic(Map<Character, Integer> dic, String p){
        dic.clear();
        for(int j=0; j< p.length(); j++){
            dic.put(p.charAt(j), dic.getOrDefault(p.charAt(j),0) + 1);
        }
    }
}
