/**
 * Created by wihoho on 13/3/16.
 */
public class StringTransform2 {

    public String solution(String s) {
        String newStr= tranform(s);

        while (newStr != s) {
            s = newStr;
            newStr = tranform(newStr);
        }

        return s;
    }

    public String tranform(String s) {
        return s.replaceAll("AB", "A").replaceAll("BA", "A").replaceAll("CB", "C").replaceAll("BC", "C").replaceAll("AA", "A").replaceAll("CC", "C");
    }

    public static void main(String[] args) {
        StringTransform2 stringTransform = new StringTransform2();
        System.out.println(stringTransform.solution("CCCCCAAAAABBCCABBBBCCCCCCAAAAAAABBBBCCCCCCCCCCCCAAAAAAAAABBBBBBBBAAAACCCACACACCAAAAAAAACCCCCCCC"));
    }
}
