package combination;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void backtracking(int[] nums, int index) {
        if (index > nums.length) {
            return;
        }
        result.add(new ArrayList<>(path));
        System.out.println(path);

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
