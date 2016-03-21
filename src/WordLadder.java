import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 16/3/2016.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        map.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String currentString = queue.poll();
            if (currentString.equals(endWord)) {
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
                            queue.add(newString);
                        }
                    }
                }

                charArray[i] = currentString.charAt(i);
            }
        }

        return map.containsKey(endWord) ? map.get(endWord) : 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();

        Set<String> words = new HashSet<>();
        words.add("a");
        words.add("b");
        words.add("c");

        int minPath = wordLadder.ladderLength("a", "c", words);
        System.out.println(minPath);
    }
}
