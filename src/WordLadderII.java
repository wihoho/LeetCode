import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/3/2016.
 */
public class WordLadderII {
    Map<String, Integer> map = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        map.put(beginWord, 0);
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        findLadders(beginWord, endWord, wordList, result, cur);
        return result;
    }

    public void findLadders(String beginWord, String endWord, Set<String> wordList, List<List<String>> result, List<String> cur) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < beginWord.length(); i++) {
            char[] charArray = beginWord.toCharArray();

            for (char j = 'a'; j <= 'z'; j++) {
                if (j != beginWord.charAt(i)) {
                    charArray[i] = j;
                    String newString = String.valueOf(charArray);
                    if (wordList.contains(newString) && !map.containsKey(newString)) {
                        map.put(newString, map.get(beginWord) + 1);
                        cur.add(newString);
                        findLadders(newString, endWord, wordList, result, cur);
                        cur.remove(cur.size() - 1);
                    }
                }
            }

            charArray[i] = beginWord.charAt(i);
        }
    }
}
