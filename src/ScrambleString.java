import java.util.Arrays;

/**
 * Created by wihoho on 12/3/16.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for(int i = 0 ; i < chars1.length; i ++) {
            if (chars1[i] != chars2[i])
                return false;
        }



        int len  = s1.length();
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        } else {
            if (s1.length() == 1) {
                return s1.equals(s2);
            }

            for (int i = 1; i < s1.length(); i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
                    return true;
                }

                if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) {
                    return true;
                }
            }


            return false;
        }
    }

    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("aa", "ab"));
    }
}
