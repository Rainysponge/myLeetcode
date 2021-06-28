package LC;

import java.util.*;

public class lc752 {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> deadSet = new HashSet<>();
        for(String each: deadends){
            if(each.equals("0000")) return -1;
            deadSet.add(each);
        }
        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int res = 0;
        queue.add("0000");
        visited.add("0000");

        while(!queue.isEmpty()){
            res++;
            int l = queue.size();
            for(int i=0; i<l; i++){
                String t = queue.poll();
                for(String next: getAll(t)){
                    if(!visited.contains(next) && !deadSet.contains(next)){
                        if(target.equals(next)){
                            return res;
                        }
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }



        return res;
    }

    char Next(char x){
        return x == '9' ? '0' : (char)(x+1);
    }

    char Pre(char x){
        return x == '0' ? '9' : (char)(x-1);
    }

    List<String> getAll(String s){
        List<String> res = new ArrayList<>();
        char[] s1 = s.toCharArray();
        for(int i=0; i<4; i++){
            char num = s1[i];
            s1[i] = Next(num);
            res.add(new String(s1));
            s1[i] = Pre(num);
            res.add(new String(s1));
            s1[i] = num;
        }
        return res;
    }



}
