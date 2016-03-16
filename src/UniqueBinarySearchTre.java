/**
 * Created by wihoho on 14/3/16.
 */
public class UniqueBinarySearchTre {

    public int numTrees(int n) {
        if (n == 1) return 1;
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTre uniqueBinarySearchTre = new UniqueBinarySearchTre();
        System.out.println(uniqueBinarySearchTre.numTrees(4));

    }
}
