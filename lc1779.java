import java.util.ArrayList;
import java.util.List;

public class lc1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1;
        double dis = 10000000;
        for(int i=0; i<points.length; i++){
            if(x==points[i][0] || y ==points[i][1]){
                double dis_tmp = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
                if(dis_tmp < dis){
                    res = i;
                    dis = dis_tmp;
                }
            }
        }
        return res;
    }
}
