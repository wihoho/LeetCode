import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 9/5/2016.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.isEmpty()) return false;
        if (str == null || str.isEmpty()) return false;

        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        String[] array = str.split(" ");

        if (array.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            String p = pattern.substring(i, i + 1);
            String c = array[i];

            if (map.containsKey(p)) {
                if (!c.equals(map.get(p))) {
                    return false;
                }
            } else {
                map.put(p, c);
            }

            if (map2.containsKey(c)) {
                if (!p.equals(map2.get(c))) {
                    return false;
                }
            } else {
                map2.put(c, p);
            }
        }

        return true;
    }
}
