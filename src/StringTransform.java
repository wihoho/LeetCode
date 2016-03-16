import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 13/3/16.
 */
public class StringTransform {
    public String solution(String s) {
        List<Integer> rules = rules(s);
        for (int i = 0; i < rules.size(); i++) {
            int ruleNum = rules.get(i);
            String temp = convert(s, ruleNum);

            if (rules(temp).isEmpty()) {
                return temp;
            }

            String nextResult = solution(temp);
            if (nextResult != null) {
                return nextResult;
            }
        }

        return null;
    }

    public String convert(String s, int ruleNum) {
        switch (ruleNum) {
            case 1:
                String newStr1 = s.replaceFirst("AB", "AA");
                return newStr1;
            case 2:
                String newStr2 = s.replaceFirst("BA", "AA");
                return newStr2;
            case 3:
                String newStr3 = s.replaceFirst("CB", "CC");
                return newStr3;
            case 4:
                String newStr4 = s.replaceFirst("BC", "CC");
                return newStr4;
            case 5:
                String newStr5 = s.replaceFirst("AA", "A");
                return newStr5;
            case 6:
                String newStr6 = s.replaceFirst("CC", "C");
                return newStr6;
        }

        return null;
    }

    public List<Integer> rules(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return result;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            String temp = s.substring(i, i + 2);

            if (temp.equals("AB")) {
                result.add(1);
            } else if (temp.equals("BA")) {
                result.add(2);

            } else if (temp.equals("CB")) {
                result.add(3);

            } else if (temp.equals("BC")) {
                result.add(4);

            } else if (temp.equals("AA")) {
                result.add(5);

            } else if (temp.equals("CC")) {
                result.add(6);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        StringTransform stringTransform = new StringTransform();
        System.out.println(stringTransform.solution("ABBCC"));
    }
}
