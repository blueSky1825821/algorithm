package greedy;

public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills) {
        //5 10 20
        int[] amounts =new int[]{0,0,0};
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                amounts[0] += 1;
            } else if (bills[i] == 10) {
                if (amounts[0] > 0) {
                    amounts[0] -= 1;
                    amounts[1] += 1;
                } else {
                    return false;
                }
            } else {
                if (amounts[0] > 0) {
                    amounts[2] += 1;
                    if (amounts[1] > 0) {
                        amounts[1] -= 1;
                        amounts[0] -= 1;
                    } else if (amounts[0] >= 3) {
                        amounts[0] -= 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
