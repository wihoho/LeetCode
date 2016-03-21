import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 18/3/2016.
 */
public class PartitionPalindrome {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, result, new ArrayList<String>(), 0);
        return result;
    }

    public void partition(String s, List<List<String>> result, List<String> cur, int runner) {
        if (runner == s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int i = runner + 1; i <= s.length(); i ++) {
            if (validate(s.substring(runner, i))) {
                cur.add(s.substring(runner, i));
                partition(s, result,cur, i);
                cur.remove(cur.size()-1);
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

    public static void main(String[] args) {
        PartitionPalindrome partitionPalindrome = new PartitionPalindrome();
        List<List<String>> result = partitionPalindrome.partition("aaab");
        System.out.println();
    }
}
