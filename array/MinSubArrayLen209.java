package array;

public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ret = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ret = Math.min(i - start + 1, ret);
                sum -= nums[start];
                start++;
            }
        }
        if (ret == Integer.MAX_VALUE) {
            return 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        int i = new MinSubArrayLen209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
}
