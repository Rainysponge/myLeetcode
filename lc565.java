package LC;

public class lc565 {
    int res = 0;
    public int arrayNesting(int[] nums) {
        int N = nums.length;
        boolean[] visited = new boolean[N];
        for(int i=0; i < N; i++){

            if(visited[i]) continue;
            int now = nums[i];
            int t = 1;  // 次数
            visited[i] = true;
            while(!visited[now]){
                visited[now] = true;
                now = nums[now];
                t++;
            }
            res = Math.max(res, t);

        }
        return res;
    }
}
