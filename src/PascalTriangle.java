import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wihoho on 15/3/16.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return new ArrayList<>();

        List<Integer> cur = new ArrayList<>();
        cur.add(1);

        List<Integer> cur1 = new ArrayList<>();
        cur1.add(1);
        cur1.add(1);

        List<List<Integer>> result = new ArrayList<>();
        result.add(cur);
        result.add(cur1);

        if (numRows == 1) {
            return Arrays.asList(cur);
        } else if (numRows == 2) {
            return Arrays.asList(cur1);
        } else {

            for (int i = 3; i <= numRows; i ++) {
                List<Integer> prev = result.get(i-2);

                List<Integer> newResult = new ArrayList<>();
                newResult.add(1);
                for(int j = 1; j < i -1; j ++) {
                    newResult.add(prev.get(j-1) + prev.get(j));
                }
                newResult.add(1);
                result.add(newResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(3);
    }

}
