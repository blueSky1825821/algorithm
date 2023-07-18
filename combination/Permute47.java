package combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/18 17:30
 */
public class Permute47 {

    public List<List<Integer>> permute(int[] nums) {

    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public void backtracking(int[] nums, int index) {
        if (index > nums.length) {
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            
        }
    }
}
