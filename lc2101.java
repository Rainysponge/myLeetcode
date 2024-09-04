import java.util.Arrays;
import java.util.Stack;

public class lc2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i=0; i<n; i++){
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);

            while (!stack.isEmpty()){
                int index = stack.pop();
                visited[index] = true;
                int[] bomb = bombs[index];
                for (int j=0; j<n; j++){
                    if (visited[j]){
                        continue;
                    }
                    if (exp(bomb, bombs[j])) {
                        stack.push(j);
                        visited[j] = true;
                        res[i] += 1;
                    }
                }

            }
        }
        return Arrays.stream(res).max().getAsInt();

    }


    boolean exp(int[] bomb1, int[] bomb2){
        // 引爆 bomb1 可以同时引爆 bomb2
        double x = (double)(bomb1[0] - bomb2[0]);
        double y = (double)(bomb1[1] - bomb2[1]);

        double dis = Math.sqrt(x * x + y * y);

        return (double) bomb1[2] >= dis;
    }


}
