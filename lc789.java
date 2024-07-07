public class lc789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance_target = Math.abs(target[0]) + Math.abs(target[1]);

        // 当鬼到target的距离小于distance_target 则return flase
        for (int[] ghost: ghosts){
            int x_g = ghost[0];
            int y_g = ghost[1];
            int _dis = Math.abs(x_g - target[0]) + Math.abs(y_g - target[1]);
            if (_dis <= distance_target){
                return false;
            }
        }

        return true;
    }
}
