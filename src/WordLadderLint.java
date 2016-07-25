import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 13/6/2016.
 */
public class WordLadderLint {
    public static void main(String[] args) {
        WordLadderLint wordLadderLint = new WordLadderLint();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        int result = wordLadderLint.ladderLength("hit", "cog", dict);
        System.out.println();
    }


    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int result = 0;
        Queue<String> nextLevel = new LinkedList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            StringBuffer sb = new StringBuffer(current);

            for (int i = 0; i < sb.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == sb.charAt(i)) {
                        continue;
                    } else {
                        StringBuffer newStringBuffer = new StringBuffer(current);
                        newStringBuffer.replace(i, i + 1, String.valueOf(c));
                        String newString = newStringBuffer.toString();

                        if (newString.equals(end)) {
                            return result + 2;
                        }

                        if (dict.contains(newString)) {
                            nextLevel.add(newString);
                            dict.remove(newString);
                        }

                    }
                }
            }

            if (queue.isEmpty()) {
                queue = nextLevel;
                nextLevel = new LinkedList<>();
                result++;
            }
        }

        return -1;
    }
}
