package greedy;

public class Candy135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //step1 从前到后，左小于右 则+1
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            } else {
                candies[i + 1] = 1;
            }
        }
        //step2 从后到前，左大于右 则+1
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                //需要在step1 基础上比较
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }
        int result = 0;
        for (int candy : candies) {
            result += candy;
        }
        return result;
    }

    public static void main(String[] args) {
        int candy = new Candy135().candy(new int[]{1, 0, 2});
        System.out.println(candy);
    }

    public int min(int[] ratings, int start, int end) {
        int min = start;
        for (int i = start + 1; i < end; i++) {
            if (ratings[i] < ratings[min]) {
                min = i;
            }
        }
        return min;
    }
}
