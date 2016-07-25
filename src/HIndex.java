/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 5/7/2016.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int size = citations.length;
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (size - middle > citations[middle]) {
                start = middle + 1;
            } else if (size - middle == citations[middle]) {
                return citations[middle];
            } else {
                end = middle - 1;
            }
        }

        return size - start;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 4, 4};
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(nums));
    }
}
