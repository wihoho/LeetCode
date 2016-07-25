import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/7/2016.
 */
public class KSmallestPair {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || k <= 0 || nums1.length == 0 || nums2.length == 0) return result;

        int m = nums1.length;
        int n = nums2.length;

        if (k > m * n) {
            k = m * n;
        }
        int[] temp = new int[n];
        int startIndex = 0;

        while (startIndex < k) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (temp[i] < m) {
                    min = Math.min(min, nums1[temp[i]] * nums2[i]);
                }
            }

            int[] current = new int[2];
            for (int i = 0; i < n; i++) {
                if (temp[i] < m && min == nums1[temp[i]] * nums2[i]) {
                    current[0] = nums1[temp[i]];
                    current[1] = nums2[i];

                    temp[i] += 1;
                    break;
                }
            }

            startIndex++;
            result.add(current);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 1, 2};
        int[] num2 = {1, 2, 3};
        KSmallestPair kSmallestPair = new KSmallestPair();
        System.out.println(kSmallestPair.kSmallestPairs(num1, num2, 10));
    }

}
