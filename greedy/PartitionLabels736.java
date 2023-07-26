package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/26 13:16
 */
public class PartitionLabels736 {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return Stream.of(0).collect(Collectors.toList());
        }
        int[] point = new int[26];
        Arrays.fill(point, 0);
        //记录每个字母的最后位置
        for (int i = 0; i < s.length(); i++) {
            point[s.charAt(i) - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(point[s.charAt(i) - 'a'], right);
            if (right == i) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }
}
