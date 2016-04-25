import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/4/2016.
 */
public class DifferentWaysToAddParenth {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        if (input == null || input.length() == 0) {
            return result;
        }

        for (int i = 1; i < input.length()-1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar != '*' && currentChar != '+' && currentChar != '-') {
                continue;
            }

            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));


            for (Integer l : left) {
                for (Integer r : right) {
                    switch (currentChar) {
                        case '*':
                            result.add(l * r);
                            break;

                        case '+':
                            result.add(l + r);
                            break;

                        case '-':
                            result.add(l - r);
                            break;
                    }

                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParenth differentWaysToAddParenth = new DifferentWaysToAddParenth();
        List<Integer> result = differentWaysToAddParenth.diffWaysToCompute("2-1-1");
        System.out.println();
    }


}
