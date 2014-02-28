package LOngestPalindromicSubString;

/**
 * Authored by GongLi at 10:46 on 27/2/14
 */


public class Solution {

    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0 || s.length() == 1) return s;

        int maxLength = 0;
        String result = "";
        int size = s.length();
        for(int i = 0; i < size; i ++){
            String potential = expand(s, i,i);
            if(maxLength < potential.length()){
                maxLength = potential.length();
                result = potential;
            }
        }

        for(int i = 1; i <= size - 1; i ++){
            String potential = expand(s, i-1, i);
            if(maxLength < potential.length()){
                maxLength = potential.length();
                result = potential;
            }
        }

        return result;


    }

    public String expand(String s, int start, int end){
        int sizeOfString = s.length();

        while(start >= 0 && end < sizeOfString && s.charAt(start) == s.charAt(end)){
            start --;
            end ++;
        }

        return s.substring(start+1, end);
    }




    public static void main(String[] args) {

        Solution s = new Solution();
        String result = s.longestPalindrome("abccbx");
        System.out.println(result);

    }


}
