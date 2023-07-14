package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/14 13:29
 */
public class NKCombination77 {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return null;
        }
        backtracking(n, k, new ArrayList<>(), 1);
        return all;
    }

    List<List<Integer>> all = new ArrayList<>();

    public void backtracking(int n, int k, List<Integer> path, int startIndex) {
        if (path.size() >= k) {
            all.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        //i <= n + 1 - (k - path.size()) 表示 该层可以访问几个数据，最后的数据不满足条件直接跳过
        for (int i = startIndex; i <= n + 1 - (k - path.size()); i++) {
            path.add(i);
            backtracking(n, k, path, ++startIndex);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new NKCombination77().combine(4, 2);
        System.out.println(combine);
    }
}
