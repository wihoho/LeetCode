package Old.DivideTwoInteger;

/**
 * Created by ligong on 15/12/2014.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, -1));
        System.out.println(s.divide(-2147483648, 1));
        System.out.println(s.divide(0, 2));

    }

    public int divide(int dividend, int divisor){
        if (divisor == 0)
            return Integer.MAX_VALUE;

        long p = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);

        int ret = 0;
        while (p >= q){
            int count = 0;
            while (p >= (q << count))
                count ++;

            ret += 1 << (count - 1);
            p -= q << (count - 1);
        }


        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            if (ret < 0)
                return Integer.MAX_VALUE;

            return (int) ret;
        }
        else {
            if (ret < 0)
                return Integer.MIN_VALUE;

            return (int) -ret;
        }
    }
}
