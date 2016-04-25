import java.util.Arrays;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/4/2016.
 */
public class ValidateAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for(int i = 0; i < sChars.length; i ++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
