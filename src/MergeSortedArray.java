/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 4/3/2016.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int start = m + n - 1;

        while (start >= 0) {
            if (n1 >= 0 && n2 >= 0) {
                if (nums1[n1] <= nums2[n2]) {
                    nums1[start--] = nums2[n2--];
                } else {
                    nums1[start--] = nums1[n1--];
                }

            } else if (n1>=0) {
                nums1[start--] = nums1[n1--];

            } else if (n2>=0) {
                nums1[start--] = nums2[n2--];
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {

    }
}
