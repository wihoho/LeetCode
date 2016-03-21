import java.util.Map;

/**
 * Created by wihoho on 6/3/16.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int size = s.length();
        if (size == 0) return 0;
        int[] ways = new int[size + 1];
        ways[0] = 1;

        int temp = Integer.valueOf(s.substring(0,1));
        if (temp > 0 && temp <= 9) {
            ways[1] = 1;
        }

        for(int i = 2; i <= size; i ++) {
            int temp1 = Integer.valueOf(s.substring(i-1, i));
            if (temp1 > 0 && temp1 <= 9) {
                ways[i] += ways[i-1];
            }

            int temp2 = Integer.valueOf(s.substring(i-2, i));
            if (temp2>=10 && temp2 <=26) {
                ways[i] += ways[i-2];
            }

        }

        return ways[size];
    }

    public int numDecodings(String s, Map<String, Integer> map) {
        if (s.length() == 0) return 0;
        if (s.length() <= 2) return map.containsKey(s) ? map.get(s) : 0;

        int result = 0;
        if (map.containsKey(s.substring(0, 1))) {
            result += numDecodings(s.substring(1)) + 1;
        }

        if (map.containsKey(s.substring(0,2))) {
            result += numDecodings(s.substring(2)) + map.get(s.substring(0,2));
        }

        return result;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("0"));
    }
}
