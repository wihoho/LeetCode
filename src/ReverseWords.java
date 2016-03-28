import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 23/3/2016.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null) return s;

        s = s.trim();
        String[] arr = s.split(" ");

        List<String> result = Arrays.stream(arr).filter(item -> !item.isEmpty()).collect(Collectors.toList());

        StringBuffer sb = new StringBuffer();
        for(int i = result.size()-1; i>=0; i --) {
            String cur = result.get(i);
            char[] chars = cur.toCharArray();

            sb.append(String.valueOf(chars));
            sb.append(" ");
        }

        if (sb.length()-1 <=0) {
            return "";
        } else {
            return sb.substring(0, sb.length() - 1);
        }
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
        String s = " ";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }
}
