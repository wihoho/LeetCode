/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/1/2016.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int[] result = new int[size + 1];

        int c = digits[size-1] + 1;
        result[size] = c % 10;
        c = c / 10;

        for (int i = size - 2; i >= 0; i--) {
            int current = c + digits[i];
            result[i+1] = current % 10;
            c = current / 10;
        }

        if (c == 0) {
            int[] finalResult = new int[size];
            for(int i = 0; i < size; i ++) {
                finalResult[i] = result[i + 1];
            }

            return finalResult;
        } else {
            result[0] = c;
            return result;
        }
    }
}
