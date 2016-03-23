import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;


        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean wordBreak(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        boolean result = false;
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                if (wordBreak(s, wordDict, i)) {
                    result = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");

        System.out.println(wordBreak.wordBreak("leetcode", set));

    }
}
