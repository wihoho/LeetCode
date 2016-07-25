import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 19/5/2016.
 */
public class RemoveInvalidPar {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (Objects.isNull(s) && s.length() == 0) return result;

        Map<Integer, Set<String>> map = new HashMap<>();
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        dfs(s, 0, 0,0,min, new StringBuffer(), map);

        Optional<Integer> minValue = map.keySet().stream().min((a, b)-> a.compareTo(b));
        if (minValue.isPresent()) {
            return map.get(minValue.get()).stream().collect(Collectors.toList());
        } else {
            return result;
        }
    }

    private void dfs(String s, int index, int left, int deletion, int[] min, StringBuffer sb, Map<Integer, Set<String>> result) {
        if (s.length() == index) {
            if (min[0] >= deletion && left == 0) {
                min[0] = deletion;

                Set<String> current = new HashSet<>();
                current.add(sb.toString());
                result.merge(min[0], current, (m, n) -> {
                    m.addAll(n);
                    return m;
                });
            }

            return;
        }

        if (s.charAt(index) == '(') {

            StringBuffer sb1 = new StringBuffer(sb);
            sb1.append("(");
            dfs(s, index + 1, left + 1, deletion, min, sb1, result);
            dfs(s, index + 1, left, deletion + 1, min, sb, result);

        } else if (s.charAt(index) == ')') {
            if (left >= 1) {
                dfs(s, index + 1, left - 1, deletion, min, new StringBuffer(sb).append(")"), result);
            }

            dfs(s, index + 1, left, deletion + 1, min, sb, result);
        } else {
            dfs(s, index + 1, left, deletion, min, sb.append(s.charAt(index)), result);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidPar removeInvalidPar = new RemoveInvalidPar();
        List<String> result= removeInvalidPar.removeInvalidParentheses("()())()");
        System.out.printf("");
    }
}
