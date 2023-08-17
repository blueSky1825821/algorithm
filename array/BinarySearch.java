package array;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        int middle = nums.length / 2;

        while (left < right) {
            if (nums[middle] > target) {
                right = middle;
                middle = left + (middle - left) / 2;
            } else if (nums[middle] < target) {
                left = middle + 1;
                middle = middle + (right - middle) / 2;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new BinarySearch().search(new int[]{1, 3, 5, 7, 9}, 8);
        System.out.println(search);
    }

}
