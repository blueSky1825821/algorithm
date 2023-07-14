package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/14 16:13
 */
public class LetterCombinations17 {
    String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return result;
        }
        backtracking(digits, nums, 0);
        return result;
    }

    public void backtracking(String digits, String[] numString, int index) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtracking(digits, numString, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
