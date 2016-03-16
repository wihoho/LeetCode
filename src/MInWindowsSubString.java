import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 2/3/2016.
 */
public class MInWindowsSubString {
    public String minWindow(String s, String t) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            patternMap.put(c, patternMap.containsKey(c) ? patternMap.get(c) + 1 : 1);
        }

        Map<Character, Integer> runnerMap = new HashMap<>();
        int lengthRunner = 0;
        int slow = 0;
        int result = Integer.MAX_VALUE;
        String finalResult = "";
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (patternMap.containsKey(currentChar)) {
                runnerMap.put(currentChar, runnerMap.containsKey(currentChar) ? runnerMap.get(currentChar) + 1: 1);
                if (runnerMap.get(currentChar) <= patternMap.get(currentChar)) lengthRunner++;

                if (lengthRunner >= t.length()) {
                    char slowChar = s.charAt(slow);
                    while (!patternMap.containsKey(slowChar) || runnerMap.get(slowChar) > patternMap.get(slowChar)) {
                        if (runnerMap.containsKey(slowChar)) runnerMap.put(slowChar, runnerMap.get(slowChar) - 1);
                        slow++;
                        slowChar = s.charAt(slow);
                    }

                    if (i - slow + 1 < result) {
                        finalResult = s.substring(slow, i + 1);
                        result = i - slow + 1;
                    }

                }
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        MInWindowsSubString mInWindowsSubString = new MInWindowsSubString();
        System.out.println(mInWindowsSubString.minWindow("ab", "b"));
    }
}
