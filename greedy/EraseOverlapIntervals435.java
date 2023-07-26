package greedy;

import java.util.Arrays;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/26 10:19
 */
public class EraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        //右边点排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int split = intervals[0][1];//记录区间分割点
        int count = 1;//非交叉点个数
        for (int i = 1; i < intervals.length; i++) {
            if (split <= intervals[i][0]) {
                split = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

}
