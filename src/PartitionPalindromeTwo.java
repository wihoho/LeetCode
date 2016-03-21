/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 18/3/2016.
 */
public class PartitionPalindromeTwo {

    public int minCut(String s) {
        int[] minValue = new int[1];
        minValue[0] = Integer.MAX_VALUE;

        partition(s, 0, minValue, 0);

        return minValue[0];
    }

    public void partition(String s, int runner, int[] minValue, int numberOfCut) {
        if (runner == s.length()) {
            if (minValue[0] > numberOfCut)
                minValue[0] = numberOfCut;
            return;
        }

        for (int i = runner + 1; i <= s.length(); i++) {
            if (validate(s.substring(runner, i))) {
                partition(s, i, minValue, numberOfCut + 1);
            }
        }
    }

    public boolean validate(String temp) {
        if (temp == null) return true;
        if (temp.length() == 0 || temp.length() == 1) return true;

        int start = 0;
        int end = temp.length() - 1;
        while (start < end) {
            if (temp.charAt(start) != temp.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
