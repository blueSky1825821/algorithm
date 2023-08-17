package array;

public class SortedSquares977 {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int k = nums.length - 1;
        int[] ints = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a > b) {
                ints[k--] = a;
                i++;
            } else {
                ints[k--] = b;
                j--;
            }
        }
        return ints;
    }
}
