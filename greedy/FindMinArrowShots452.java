package greedy;

import java.util.Arrays;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/25 17:14
 */
public class FindMinArrowShots452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (x, y) -> x[0] - y[0]);
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            //不重合
            if (points[i][0] > points[i - 1][1]) {
                result++;
                //有重合
            } else {
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return result;
    }
}
