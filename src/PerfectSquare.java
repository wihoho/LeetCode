import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 27/4/2016.
 */
public class PerfectSquare {
    public int numSquares(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 1);

        int result = helper(n, map);
        return result;
    }

    public int helper(int n, Map<Integer, Integer> map) {
        int sqrt = (int) Math.sqrt(n);
        if (n == sqrt * sqrt) {
            map.put(n, 1);
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int max = (int) Math.sqrt(n);

        int result = Integer.MAX_VALUE;
        for (int i = max; i >= 1; i--) {
            int candidate = helper(n - (int) Math.pow(i, 2), map) + 1;
            result = result > candidate ? candidate : result;
        }

        map.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        System.out.println(perfectSquare.numSquares(12));
    }

}
