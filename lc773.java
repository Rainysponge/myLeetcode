package LC;

import java.util.*;

public class lc773 {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder startB = new StringBuilder();
        for(int i=0; i<2; i++){
            for (int j=0; j<3; j++){
//                char c =
                startB.append(Integer.valueOf(board[i][j]));
            }
        }
        String start = startB.toString();
        System.out.println("Start" + start);
        if(start.equals(target)) return 0;
        Deque<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int res = 0;

        while(!queue.isEmpty()){
            res++;
            int l = queue.size();
            for(int i=0; i<l; i++){
                String t = queue.poll();
                for(String each: getAll(t)){
                    if(!visited.contains(each)){
                        System.out.println(each);
                        if(target.equals(each)){
                            return res;
                        }
                        queue.add(each);
                        visited.add(each);
                    }
                }
            }
        }



        return -1;


    }

    public List<String> getAll(String s){
        List<String> res = new ArrayList<>();
        char[] s1 = s.toCharArray();
        int find = 0;
        for(int i=0; i<6; i++){
            if(s1[i] == '0'){
                find = i;
                break;
            }
        }
        int m = 0, n = 0;
        m = find / 3;
        n = find % 3;
        // find = m*3 + n;
        // 4
        int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] move: moves){
            int tmpM = m, tmpN = n;
            tmpM += move[0];
            tmpN += move[1];
            if(tmpM<0 || tmpM>1 || tmpN<0 || tmpN>2){
                continue;
            }

            int findNew = tmpM*3 + tmpN;
            s1[find] = s1[findNew];
            s1[findNew] = '0';
            res.add(new String(s1));
            s1[findNew] = s1[find];
            s1[find] = '0';
        }


        return res;

    }


}
