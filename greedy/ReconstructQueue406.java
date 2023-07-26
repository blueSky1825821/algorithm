package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * todo: 多注意，数组的转换
 */
public class ReconstructQueue406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                //正序
                return a[1] - b[1];
            }
            //倒序
            return b[0] - a[0];
        });
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][1]);
    }
}
