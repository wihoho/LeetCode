import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 9/3/2016.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() >= 13) {
            return new ArrayList<>();
        }

        helper(4, 0, s, "", result);
        return result;
    }

    public void helper(int numberOfDots, int start, String originalString, String currentSolution, List<String> result) {
        if (numberOfDots == 0 && start >= originalString.length()) {
            result.add(currentSolution);
            return;
        }

        for (int i = 1; i < 4; i++) {
            int end = start + i;
            if (end <= originalString.length()) {
                String temp = originalString.substring(start, end);
                Integer integer = Integer.valueOf(temp);
                if (String.valueOf(integer).length() != temp.length()) {
                    return;
                }
                if (integer >= 0 && integer <= 255) {
                    helper(numberOfDots - 1, end, originalString, currentSolution.equals("") ? originalString.substring(start, end) : currentSolution + "." + originalString.substring(start, end), result);
                }

            }
        }

    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> result = restoreIPAddresses.restoreIpAddresses("25525511135");
        System.out.println();
    }
}
