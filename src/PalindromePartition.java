import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 13/6/2016.
 */
public class PalindromePartition {

    public static void main(String[] args) {
        PalindromePartition palindromePartition = new PalindromePartition();
        List<List<String>> result = palindromePartition.partition("aab");
        System.out.println();
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void solve(String s, int pos, List<String> current, List<List<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int start = pos + 1; start <= s.length(); start++) {
            if (isPalindrome(s, pos, start - 1)) {
                current.add(s.substring(pos, start));
                solve(s, start, current, result);
                current.remove(current.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


}
