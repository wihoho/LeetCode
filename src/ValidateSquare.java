/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/7/2016.
 */
public class ValidateSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;

        long start = 1;
        long end = num;

        while (start + 1 < end) {
            long middle = start + (end - start) / 2;
            long square = middle * middle;
            if (square == num) {
                return true;
            } else if (square < num) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (start * start == num) {
            return true;
        }

        if (end * end == num) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ValidateSquare validateSquare = new ValidateSquare();
        System.out.println(validateSquare.isPerfectSquare(808201));

    }
}
