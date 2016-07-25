/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 19/7/2016.
 */
public class GuessNumber {
    private int target = 5;

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int result = guess(middle);

            if (result == 0) {
                return middle;
            } else if (result == -1) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    private int guess(int x) {
        if (x == target) {
            return 0;
        } else if (x < target) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        System.out.println(guessNumber.guessNumber(10));
    }
}
