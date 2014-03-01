package IntegerToRoman;

/**
 * Authored by GongLi at 16:59 on 1/3/14
 */


public class Solution {

    public String intToRoman(int num) {

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int i=0;
        while (num>0) {
            int times = num / nums[i];
            num -= nums[i]*times;
            for (; times>0; times--) {
                res.append(symbols[i]);
            }
            ++i;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(54321));
    }
}
