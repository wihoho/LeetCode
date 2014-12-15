package strStr;

/**
 * Created by ligong on 15/12/2014.
 */
public class Solution {
    public boolean checkExists(String haystack, String needle, int index){

        for (int i = 0; i < needle.length(); i ++){
            int j = index + i;

            if (j < haystack.length() && haystack.charAt(j) == needle.charAt(i))
                continue;
            else
                return false;
        }

        return true;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i + 1 < needle.length())
                return -1;

            int k = i;
            int j = 0;

            while (j < needle.length() && k < haystack.length() && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needle.length())
                    return i;
            }

        }


        return -1;
    }
}
