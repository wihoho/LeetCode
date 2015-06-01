import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GongLi on 23/5/15.
 */
public class SubStringWithConcatenationsOfAllWords {

    public static void main(String[] args) {
//        String[] words = {"foo", "bar"};
//        List<Integer> result = findSubstring("barfoothefoobarman", words);
//
//        System.out.println(result);


        String[] words1 = {"a", "a"};
        List<Integer> result1 = findSubstring("aaaaaaaa", words1);

        System.out.println(result1);
    }

    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || L.length == 0)
            return result;

        if (S.length() < L[0].length() * L.length)
            return result;

        Map<String, Integer> wordLabel = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (!wordLabel.containsKey(L[i])) {
                wordLabel.put(L[i], 0);
            }

            wordLabel.put(L[i], wordLabel.get(L[i]) + 1);
        }

        int m = L.length;
        int n = L[0].length();

        int runner = 0;
        while (runner <= S.length() - m * n) {
            int tempResult = check(S, runner, m, n, wordLabel);
            if (tempResult >= 0) {
                result.add(tempResult);
            }

            runner += 1;
        }

        return result;

    }


    public static int check(String target, int start, int m, int n, Map<String, Integer> wordLabels) {

        Map<String, Integer> checkMap = new HashMap<String, Integer>();
        int end = start + (m - 1) * n;

        int runner = start;

        while (runner <= end) {
            String current = target.substring(runner, runner + n);
            if (wordLabels.containsKey(current)) {
                if (!checkMap.containsKey(current)) {
                    checkMap.put(current, 1);
                } else {
                    checkMap.put(current, checkMap.get(current) + 1);
                }

                if (wordLabels.get(current) < checkMap.get(current)) {
                    return -1;
                }

            } else {
                return -1;
            }

            runner += n;
        }

        return start;
    }


}
