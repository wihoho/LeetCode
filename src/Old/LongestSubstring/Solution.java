package Old.LongestSubstring;

/**
 * Authored by GongLi at 22:46 on 26/2/14
 */


public class Solution {

    public int lengthOfLongestSubstring(String s){

        if(s == null) return 0;
        int sizeS = s.length();

        if(sizeS == 0) return 0;

        int maxLength = 1;
        int start = 0;
        for(int i = 1; i < sizeS; i ++){

            char examineChar = s.charAt(i);

            int j = start;
            for(; j <= i - 1; j ++){
                if(examineChar == s.charAt(j)){
                    start = j + 1;
                    break;
                }
            }

            if (j == i)
                maxLength = (maxLength >(i - start + 1)) ? maxLength: i - start + 1;



        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("abcabc"));
    }
}
