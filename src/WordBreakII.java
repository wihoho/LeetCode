import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/3/2016.
 */
public class WordBreakII {
    Map<String, List<String>> res = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);

            if (wordDict.contains(pre)) {
                if (i == s.length()) wordDict.add(pre);
                else {

                    String remainString = s.substring(i, s.length());
                    List<String> remain = res.containsKey(remainString) ? res.get(remainString) : wordBreak(remainString, wordDict);

                    if (!remain.isEmpty()) {
                        for (String item : remain) {
                            result.add(pre + " " + item);
                        }

                        res.put(remainString, remain);
                    }
                }
            }
        }

        return result;
    }


}
