import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 10/12/2015.
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        k = k -1;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }

        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        factorial[1] = 1;

        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= n; i++) {
            int currentPosition = k / factorial[n - i];
            k = k % factorial[n-i];

            sb.append(candidates.get(currentPosition));
            candidates.remove(currentPosition);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3, 5));
    }
}
