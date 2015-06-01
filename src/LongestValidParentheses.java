import java.util.Stack;

/**
 * Created by GongLi on 30/5/15.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int last = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            switch (currentChar) {

                case '(':
                    stack.push(i);

                    break;

                case ')':
                    if (stack.isEmpty()) {
                        last = i;
                        continue;
                    }
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, i - last);
                    else
                        max = Math.max(max, i - stack.peek());

                    break;
            }


        }

        return max;


    }
}
