import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 17/3/2016.
 */
public class WordLadderTwo {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        List<String> queue = new ArrayList<>();
        queue.add(beginWord);
        map.put(beginWord, 0);

        List<String> tempResult = new ArrayList<>();
        while (!queue.isEmpty()) {

            List<String> nextLevel = new ArrayList<>();

            for (String currentString : queue) {
                tempResult.add(currentString);

                if (currentString.equals(endWord)) {
                    result.add(new ArrayList<>(tempResult));
                    break;
                }

                for (int i = 0; i < currentString.length(); i++) {
                    char[] charArray = currentString.toCharArray();

                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != currentString.charAt(i)) {
                            charArray[i] = j;
                            String newString = String.valueOf(charArray);
                            if (wordList.contains(newString) && !map.containsKey(newString)) {
                                map.put(newString, map.get(currentString) + 1);

                                nextLevel.add(newString);
                            }
                        }
                    }

                    charArray[i] = currentString.charAt(i);
                }

                tempResult.remove(tempResult.size() - 1);
            }

            queue = nextLevel;
        }

        return result;
    }

    public static void main(String[] args) {

        WordLadderTwo wordLadder = new WordLadderTwo();

        Set<String> words = new HashSet<>();
        words.add("a");
        words.add("b");
        words.add("c");

         List<List<String>> result = wordLadder.findLadders("a", "c", words);
        System.out.println(result);
    }


}
