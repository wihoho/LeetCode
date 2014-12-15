package LongestCommonPrefix;


/**
 * Authored by GongLi at 17:06 on 1/3/14
 */


public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String commonPrefix = strs[0];
        for(int i  = 1; i < strs.length; i ++){

            String current = strs[i];
            int size = Math.min(commonPrefix.length(),current.length());
            int startTestIndex = 0;
            for(; startTestIndex < size; startTestIndex ++){
                if(commonPrefix.charAt(startTestIndex) != current.charAt(startTestIndex))
                    break;
            }

            commonPrefix = commonPrefix.substring(0, startTestIndex);
            if(commonPrefix == "") return commonPrefix;
        }

        return commonPrefix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] strs = {"aa", "a"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
