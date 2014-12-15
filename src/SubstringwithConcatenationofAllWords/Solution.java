package SubstringwithConcatenationofAllWords;

import java.util.*;

/**
 * Created by ligong on 15/12/2014.
 */
public class Solution {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || L.length == 0)
            return result;

        if (S.length() < L[0].length())
            return result;

        Map<String, Integer> wordLabel = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i ++){
            wordLabel.put(L[i], i);
        }

        Map<Integer, Integer> matches = new HashMap<Integer, Integer>();
        int wordSize = L[0].length();

        for (int i = 0; i < S.length(); i++){
            if (i + wordSize > S.length())
                break;

            String currentSubString = S.substring(i, i+ wordSize);
            if (wordLabel.containsKey(currentSubString))
                matches.put(i, wordLabel.get(currentSubString));
        }

        Set<Integer> set = matches.keySet();
        for(Integer i: set){
            boolean flag = true;

            Set<Integer> examinedResult = new HashSet<Integer>();
            for (int j = 0; j < L.length; j ++) {
                if (!set.contains(i + wordSize * j)){
                    flag = false;
                    break;
                }

                examinedResult.add(matches.get(i + wordSize * j));
            }

            for(int index = 0; index < L.length; index ++){
                if (! examinedResult.contains(index)){
                    flag = false;
                    break;
                }
            }

            if (flag)
                result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] L = {"foo", "bar"};
        s.findSubstring("barfoothefoobarman", L);
    }



}
