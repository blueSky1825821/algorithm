package combination;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public void backtracking(String s, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i + 1)) {
                String sub = s.substring(index, i + 1);
                path.add(sub);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> rs = new Partition131().partition("aab");
        System.out.println(rs);
    }
}
