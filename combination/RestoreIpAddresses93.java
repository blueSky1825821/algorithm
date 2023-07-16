package combination;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return result;
    }

    List<String> path = new ArrayList<>();
    List<String> result = new ArrayList<>();

    public void backtracking(String s, int index) {
        if (index >= s.length()) {
            if (path.size() == 4) {
                String join = String.join(".", (List) path);
                result.add(join);
                System.out.println(join);
            }
            return;
        }

        for (int i = index; i < s.length() && i < index + 3 && path.size() < 4; i++) {
            String sub = s.substring(index, i + 1);
            if (!check(sub)) {
                continue;
            }
            path.add(sub);
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean check(String sub) {
        if (sub.equals("00") || sub.equals("000") || (sub.length() > 1 && sub.startsWith("0"))) {
            return false;
        }
        return Integer.parseInt(sub) <= 255;
    }

    public static void main(String[] args) {
        List<String> rs = new RestoreIpAddresses93().restoreIpAddresses("25525511135");
        System.out.println(rs);
    }
}
