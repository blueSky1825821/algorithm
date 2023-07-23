package greedy;

public class CanCompleteCircuit134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从i开始
        for (int i = 0; i < gas.length; i++) {
            int total = 0;
            for (int j = i; j < i + gas.length; j++) {
                if (j < gas.length) {
                    total += gas[j] - cost[j];
                } else {
                    total += gas[j - gas.length] - cost[j - gas.length];
                }
                if (total < 0) {
                    break;
                }
            }
            if (total >= 0) {
                return gas[i];
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int cur = 0;
        int position = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            //假设存在position开始都>=0
            //<0则position + 1开始
            if (cur < 0) {
                position = i + 1;
                cur = 0;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return position;
    }

    public static void main(String[] args) {
        int i = new CanCompleteCircuit134().canCompleteCircuit2(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }
}
