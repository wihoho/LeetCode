import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 5/7/2016.
 */
public class ExpressionsAndOperators {
    public static void main(String[] args) {
        ExpressionsAndOperators expressionsAndOperators = new ExpressionsAndOperators();
        List<String> result = expressionsAndOperators.addOperators("105", 5);
        System.out.println();
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= num.length(); i++) {
            if (isValid(num.substring(0, i))) {
                Long currentInteger = Long.valueOf(num.substring(0, i));
                StringBuffer sb = new StringBuffer();
                sb.append(currentInteger);
                help(num, currentInteger, target, i, sb, currentInteger, result);
            }
        }
        return result;
    }

    private void help(String num, long currentValue, int target, int currentIndex, StringBuffer sb, long lastOperand, List<String> result) {
        if (currentIndex == num.length()) {
            if (currentValue == target) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = currentIndex + 1; i <= num.length(); i++) {
            if (isValid(num.substring(currentIndex, i))) {
                Long currentInteger = Long.valueOf(num.substring(currentIndex, i));
                int currentSbSize = sb.length();

                sb.append("*");
                sb.append(currentInteger);
                help(num, currentValue - lastOperand + lastOperand * currentInteger, target, i, sb, lastOperand * currentInteger, result);
                sb.delete(currentSbSize, sb.length());

                sb.append("+");
                sb.append(currentInteger);
                help(num, currentValue + currentInteger, target, i, sb, currentInteger, result);
                sb.delete(currentSbSize, sb.length());

                sb.append("-");
                sb.append(currentInteger);
                help(num, currentValue - currentInteger, target, i, sb, -currentInteger, result);
                sb.delete(currentSbSize, sb.length());
            }
        }
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        if (s.charAt(0) == '0') {
            if (s.length() == 1) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

}
