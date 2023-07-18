package combination;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0, used);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();


    public void backtracking(int[] nums, int index, boolean[] used) {
        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) //同层处理时（理论不同层的话会先处理前节点），如果重复，跳过
                    || used[i]) { //同节点重复遍历，跳过
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Permute47().permuteUnique(new int[]{3,3,0,3});
        System.out.println(subsequences);
    }
}
