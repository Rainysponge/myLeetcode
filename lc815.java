package LC;

import java.util.*;

public class lc815 {
    // BFS
    int N;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        N = routes.length;
        int res = -1;
        for(int i=0; i<N; i++){
            for(int each: routes[i]){
                List<Integer> t;
                if(map.containsKey(each)){
                    t = map.get(each);
                }else{
                    t = new ArrayList<>();
                }
                t.add(i);
                map.put(each, t);
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];



        for(int eachBus: map.get(source)){
            visited[eachBus] = true;
            queue.add(eachBus);
            res = 0;
        }


        while(!queue.isEmpty()){
            res++;
            int l = queue.size();
            for(int i=0; i<l; i++){
                int bus = queue.poll();
                for(int eachStation: routes[bus]){
                    if(eachStation == target)
                        return res;
                    for(int eachBus: map.get(eachStation)){
                        if(!visited[eachBus]){
                            visited[eachBus] = true;
                            queue.add(eachBus);
                        }
                    }
                }
            }
        }
        return -1;

    }
}
