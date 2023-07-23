package greedy;

public class Jump45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int total = 0;
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int end = maxIndex + i;
            //直到最远距离
            for (int j = i; j < end && j < nums.length; j++) {
                maxIndex = Math.max(nums[j], maxIndex - 1);
                i = j;
            }
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        int jump = new Jump45().jump(new int[]{3, 2, 1, 1, 4});
        System.out.println(jump);
    }
}
