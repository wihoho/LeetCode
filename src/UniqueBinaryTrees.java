/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 14/3/2016.
 */
public class UniqueBinaryTrees {
    public int generateTrees(int n) {
        return generate(1, n);
    }

    public int generate(int start, int end) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        int result = 0;
        for (int i = start; i <= end; i++) {

            int left = generate(start, i - 1);
            int right = generate(i + 1, end);

            if (left == 0) {
                result += right;
            } else if (right == 0) {
                result += left;
            } else {
                result += left * right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        UniqueBinaryTrees uniqueBinaryTrees = new UniqueBinaryTrees();
        System.out.println(uniqueBinaryTrees.generateTrees(2));
    }
}
