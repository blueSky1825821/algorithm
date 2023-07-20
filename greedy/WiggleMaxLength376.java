package greedy;

public class WiggleMaxLength376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int curDiff = 0;
        int preDiff = 0;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if (curDiff > 0) {
                if (preDiff > 0) {
                    continue;
                } else {
                    count++;
                    preDiff = curDiff;
                }
            } else if (curDiff == 0) {
                continue;
            } else {
                if (preDiff < 0) {
                    continue;
                } else {
                    count++;
                    preDiff = curDiff;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int i = new WiggleMaxLength376().wiggleMaxLength(new int[]{1,7,4,9,2,5});
        int i = new WiggleMaxLength376().wiggleMaxLength(new int[]{3, 3, 3, 2, 5});
        System.out.println(i);
    }
}
