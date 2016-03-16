import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 13/3/16.
 */
public class DemoTest {

    public int solution(int[] A) {
        if (A == null || A.length == 0) return -1;

        int sum = 0;
        for(int i = 0; i < A.length; i ++) {
            sum += A[i];
        }

        int beforeSum = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < A.length; i ++) {
            beforeSum += A[i-1];
            if (beforeSum == sum - beforeSum-A[i]) {
                result.add(i);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        DemoTest demoTest = new DemoTest();
        int[] A = {};
        System.out.println(demoTest.solution(A));
    }
}
