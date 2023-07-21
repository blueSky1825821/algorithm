package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/19 14:32
 */
public class FindContentChildren455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int sum = 0;
        for (int i = g.length - 1; i > 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                index--;
                sum++;
            }
        }
        return sum;
    }
}
