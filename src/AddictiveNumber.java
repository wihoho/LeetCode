/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/5/2016.
 */
public class AddictiveNumber {

    public boolean isAdditiveNumber(String num) {
        boolean[] result = new boolean[1];

        for (int i = 1; i <= num.length() - 2; i++) {
            for (int j = i + 1; j <= num.length() - 1; j++) {
                String firstNum = num.substring(0, i);
                if (firstNum.equals("") || (firstNum.startsWith("0") && firstNum.length() >= 2)) {
                    continue;
                }

                String secondNum = num.substring(i, j);
                if (secondNum.equals("") || (secondNum.startsWith("0") && secondNum.length() >= 2)) {
                    continue;
                }

                int[] prev = new int[2];
                prev[0] = Long.valueOf(firstNum).intValue();
                prev[1] = Long.valueOf(secondNum).intValue();

                isAdditiveNumberHelper(num, j, prev, result);
                if (result[0]) {
                    return true;
                }

            }
        }

        return false;
    }

    private void isAdditiveNumberHelper(String num, int index, int[] prev, boolean[] result) {
        if (!result[0]) {
            if (index == num.length()) {
                result[0] = true;
                return;
            }

            int nextNum = prev[0] + prev[1];
            String nextNumStr = String.valueOf(nextNum);

            if (index + nextNumStr.length() <= num.length()) {
                String temp = num.substring(index, index + nextNumStr.length());
                if (temp.equals(nextNumStr)) {
                    prev[0] = prev[1];
                    prev[1] = nextNum;

                    isAdditiveNumberHelper(num, index + nextNumStr.length(), prev, result);
                }
            }
        }
    }


    public static void main(String[] args) {
        AddictiveNumber addictiveNumber = new AddictiveNumber();
        boolean result = addictiveNumber.isAdditiveNumber("121474836472147483648");
        System.out.println();

    }
}
