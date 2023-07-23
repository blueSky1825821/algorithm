package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestSumAfterKNegations1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        nums = sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            if (i != nums.length - 1) {
                sum += nums[i];
            }
        }
        if (k > 0 && k % 2 != 0) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        sum += nums[nums.length - 1];
        return sum;
    }

    /**
     * 绝对值倒排
     */
    public int[] sort(int[] nums) {
        return IntStream.of(nums)
                .boxed()
                .sorted((a, b) -> Math.abs(b) - Math.abs(a))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int i = new LargestSumAfterKNegations1005().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
        System.out.println(i);
    }
}
