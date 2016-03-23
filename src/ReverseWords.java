/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 23/3/2016.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);

                if (i - 1 >= 0) {
                    start = i + 1;
                }
            }
        }

        reverse(arr, start, arr.length - 1);

        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "I am Gong Li";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }
}
