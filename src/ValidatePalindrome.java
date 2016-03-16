/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 16/3/2016.
 */
public class ValidatePalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            while (start <= end && !(Character.isAlphabetic(s.charAt(start)) || Character.isDigit(s.charAt(start)))) {
                start++;
            }

            while (start <= end && !(Character.isAlphabetic(s.charAt(end)) || Character.isDigit(s.charAt(end)))) {
                end--;
            }

            if (start > end) {
                break;
            }

            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            String staString = String.valueOf(startChar);
            String endString = String.valueOf(endChar);

            if (staString.equalsIgnoreCase(endString)) {
                start++;
                end--;
            } else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        System.out.println(validatePalindrome.isPalindrome("0P"));
        System.out.println(validatePalindrome.isPalindrome(".,"));

    }

}
