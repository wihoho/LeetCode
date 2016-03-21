/**
 * Created by wihoho on 3/3/16.
 */
public class SearchInRotatedSortedArrayTwo {

    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                return true;
            }

            if (A[middle] == A[start] && A[middle] == A[end]) {
                start ++;
                end --;
            } else if (A[middle] == A[start]) {
                start = middle + 1;
            } else if (A[middle] == A[end]) {
                end = middle - 1;
            } else if (A[middle] > A[start]) {

                if (target < A[middle] && target >= A[start]) end = middle - 1;
                else start = middle + 1;
            } else if (A[middle] < A[end]) {
                if (target <= A[end] && target > A[middle]) start = middle + 1;
                else end = middle - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
