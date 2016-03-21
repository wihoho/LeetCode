/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class SingleNumberTwo {

    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i : nums) {
            int currentNum = i;

            int pos = 0;
            while (currentNum / 2 >= 1) {
                arr[pos] += currentNum % 2;
                currentNum /= 2;
                pos++;
            }

            arr[pos] += currentNum % 2;

        }

        for(int i = 0; i < arr.length; i ++) {
            arr[i] %= 3;
        }

        int result = 0;
        for(int i = 0; i < arr.length; i ++) {
            result += Math.pow(2, i) * arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7};
        SingleNumberTwo singleNumberTwo = new SingleNumberTwo();
        System.out.println(singleNumberTwo.singleNumber(A));
    }
}
