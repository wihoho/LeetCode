import java.util.List;

/**
 * Created by wihoho on 15/3/16.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> result = triangle.get(triangle.size() - 1);

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result.set(j, Math.min(result.get(j), result.get(j+1) + triangle.get(i).get(j)));
            }
        }

        return result.get(0);
    }


}
