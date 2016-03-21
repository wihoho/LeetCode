import java.util.HashMap;
import java.util.Map;

/**
 * Created by wihoho on 13/3/16.
 */
public class PairCount {
    public int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int result = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            result += count(value);

            if (result >= 1000000000)
                return 1000000000;
        }

        return result;
    }

    public int count(int a) {
        // count the number from 1..a-1;
        if (a <= 1) return 0;
        return a*(a-1)/2;
    }

    public static void main(String[] args) {
        PairCount pairCount = new PairCount();

        int[] arr = {3, 5, 6, 3, 3, 5};
        System.out.println(pairCount.solution(arr));
    }
}
