import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/12/2015.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arrays = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();

//        List<List<String>> result = groupAnagrams.groupAnagrams(arrays);
        System.out.println();

        System.out.println(groupAnagrams.hash("and"));
        System.out.println(groupAnagrams.hash("dna"));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        for (String s : strs) {
            int hashValue = hash(s);
            List<String> temp = new ArrayList<String>();
            temp.add(s);

            map.merge(hashValue, temp, (a, b) -> {
                a.addAll(b);
                return a;
            });
        }

        for (List<String> lst : map.values()) {
            Collections.sort(lst);
        }

        return map.values().stream().collect(Collectors.toList());
    }

    private int hash(String s) {
        int hash = 0;
        int a = 378551;
        int b = 63689;

        int[] count = new int[26];
        for(char ch: s.toCharArray()) {
            count[ch-'a'] ++;
        }
        for (int ch : count) {
            hash = hash * a + ch;
            a = a * b;
        }
        return hash;
    }
}
