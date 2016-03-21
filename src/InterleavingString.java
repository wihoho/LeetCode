/**
 * Created by wihoho on 14/3/16.
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m1 = s1.length();
        int m2 = s2.length();
        int m3 = s3.length();

        if (m1 + m2 != m3) {
            return false;
        }

        boolean[][] matches = new boolean[m1 + 1][m2 + 1];
        for (int i = 0; i <= m1; i++) {
            for (int j = 0; j <= m2; j++) {
                if (i == 0 && j == 0) matches[i][j] = true;
                else if (i == 0) matches[i][j] = matches[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                else if (j == 0) matches[i][j] = matches[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                else {
                    matches[i][j] = (matches[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (matches[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return matches[m1][m2];
    }

    public static void main(String[] args) {

    }
}
