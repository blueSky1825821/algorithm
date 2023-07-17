package combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void backtracking(int[] nums, int index) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        //本层已经使用过的数据
        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            //递增
            if ((path.size() > 0 && nums[i] < path.get(path.size() - 1))
                    || used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> subsequences = new FindSubsequences491().findSubsequences(new int[]{1,9,10,1,1,1});
        System.out.println(subsequences);
    }
}
