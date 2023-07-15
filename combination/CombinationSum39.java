package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        if (sum > target || index >= candidates.length) {
            System.out.println("sum:" + sum + " skip");
            return;
        }

        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, sum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum39().combinationSum(new int[]{8,7,4,3}, 11);
        System.out.println(result);
    }

}
