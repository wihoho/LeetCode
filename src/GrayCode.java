import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 5/3/16.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0){
            result.add(0);
            return result;
        } else if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }

        result.add(0);
        result.add(1);
        for(int i = 1; i < n; i ++) {
            int temp = 1 << i;

            for(int j = result.size() - 1; j >= 0; j --) {
                result.add(result.get(j) + temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> result = grayCode.grayCode(3);
        System.out.println();
    }
}
