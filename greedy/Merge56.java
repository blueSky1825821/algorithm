package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/26 14:02
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int right = intervals[0][1];
        int left = intervals[0][0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            //重合
            if (intervals[i][0] <= right) {
                right = intervals[i][1];
            } else {
                //不重合
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] merge = new Merge56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
    }
}
