import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    public boolean wordBreak(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        boolean result = false;
        for(int i = start+1; i <= s.length(); i ++) {
            if (wordDict.contains(s.substring(start, i))) {
                if (wordBreak(s, wordDict, i)) {
                    result = true;
                };
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("aaaa");

        System.out.println(wordBreak.wordBreak("aaaaaaa", set));

    }
}
