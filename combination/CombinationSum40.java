package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void backtracking(int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length && target - candidates[i] >= 0; i++) {
            //i > index 正在遍历表示同一层
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            target -= candidates[i];
            backtracking(candidates, target, i + 1);
            target += candidates[i];
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum40().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(result);
    }
}
