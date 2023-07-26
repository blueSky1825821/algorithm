package greedy;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/26 14:59
 */
public class MonotoneIncreasingDigits738 {
    public int monotoneIncreasingDigits(int n) {
        for (int i = n; i > 0; i--) {
            int max = i % 10;
            int num = i / 10;
            while (num != 0) {
                if (num % 10 >= max) {
                    break;
                } else {
                    max = num % 10;
                }
                num = num / 10;
            }
            if (num == 0) {
                return i;
            }
        }
        return -1;
    }

    public int monotoneIncreasingDigits2(int n) {
        char[] charArray = (String.valueOf(n)).toCharArray();
        int start = charArray.length;
        for (int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i] > charArray[i + 1]) {
                charArray[i + 1] = '9';
                charArray[i] = (char) (Math.abs(charArray[i] - '0' - 1) + '0');
                start = i + 1;
            }
        }
        for (int i = start; i < charArray.length; i++) {
            charArray[i] = '9';
        }
        return Integer.parseInt(new String(charArray));
    }

    public static void main(String[] args) {
        int i = new MonotoneIncreasingDigits738().monotoneIncreasingDigits2(100);
        System.out.println(i);
    }
}
