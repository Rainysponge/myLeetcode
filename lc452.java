package LC;

import java.util.Arrays;
import java.util.Comparator;

public class lc452 {
    //在二维空间中有许多球形的气球。对于每个气球，
    // 提供的输入是水平方向上，气球直径的开始和
    // 结束坐标。由于它是水平的，所以纵坐标并不
    // 重要，因此只要知道开始和结束的横坐标就足
    // 够了。开始坐标总是小于结束坐标。
    //
    //一支弓箭可以沿着 x 轴从不同点完全垂直地射出
    // 。在坐标 x 处射出一支箭，若有一个气球的直
    // 径的开始和结束坐标为 xstart，xend， 且
    // 满足 xstart≤ x ≤ xend，则该气球会被引
    // 爆。可以射出的弓箭的数量没有限制。 弓箭一
    // 旦被射出之后，可以无限地前进。我们想找到使
    // 得所有气球全部被引爆，所需的弓箭的最小数量。
    //
    //给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int[] point : points) {
            System.out.println(Arrays.toString(point));
        }
        return 1;
    }
}
