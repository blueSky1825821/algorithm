package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/14 15:10
 */
public class CombinationSum216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void backtracking(int k, int n, int start, int sum) {
        if (path.size() >= k) {
            if (sum == n) {
                System.out.println(path);
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i < 10 - (k - path.size()); i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, ++start, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new CombinationSum216().combinationSum3(3, 9);
        System.out.println(combine);
    }
}
