import java.util.Objects;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 7/12/2015.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = " ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord(s));
    }


    public int lengthOfLastWord(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }

        int start = s.length() - 1;
        while (start >= 0 && s.charAt(start) == ' ') {
            start--;
        }

        if (start == -1) {
            return 0;
        }

        int result = 0;
        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                result++;
            }
        }

        return result;
    }
}
