package combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    //这其实是深度遍历，来统计已使用的元素
    Set<Integer> used = new HashSet<>();


    public void backtracking(int[] nums) {
        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                path.add(nums[i]);
            } else {
                continue;
            }
            backtracking(nums);
            used.remove(nums[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Permute46().permute(new int[]{1,9,10});
        System.out.println(subsequences);
    }
}
