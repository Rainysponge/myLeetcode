package LC;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class lc76 {
    // HashTable + 滑动窗口
    Map<Character, Integer> tDic = new HashMap<Character, Integer>();
    Map<Character, Integer> sSubDic = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        // 统计t个字母个数
        int tLen = t.length();
        int i;
        for(i=0; i<tLen; i++){
            char c = t.charAt(i);
            tDic.put(c, tDic.getOrDefault(c,0) + 1);
        }

        int winLeft = 0, winRight = -1;
        int sLen = s.length();
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while(winRight < sLen){
            winRight++;
            if(winRight< sLen && tDic.containsKey(s.charAt(winRight))){
                sSubDic.put(s.charAt(winRight), sSubDic.getOrDefault(s.charAt(winRight), 0)+1);
            }
            while(check() && winLeft <= winRight){
                if(winRight - winLeft + 1 < len){
                    len = winRight - winLeft + 1;
                    ansL = winLeft;
                    ansR = len + winLeft;
                }
                if(tDic.containsKey(s.charAt(winLeft))){
                    sSubDic.put(s.charAt(winLeft), sSubDic.getOrDefault(s.charAt(winLeft),0)-1);
                }
                winLeft++;
            }
        }



        return ansL==-1?"":s.substring(ansL, ansR);

    }


    private boolean check(){
        // 迭代器, 可是简单地理解为链表
        for (Map.Entry<Character, Integer> characterIntegerEntry : tDic.entrySet()) {
            Map.Entry entry = (Map.Entry) characterIntegerEntry;
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sSubDic.getOrDefault(key, 0) < val) {
                return false;
            }

        }
        return true;
    }
}
