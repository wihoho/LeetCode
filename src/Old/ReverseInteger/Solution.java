package Old.ReverseInteger;

/**
 * Authored by GongLi at 20:24 on 28/2/14
 */


public class Solution {

    public int reverse(int x){
        if(x <10 && x > -10) return x;

        if(x > 0) return reversePositive(x);
        else return 0 - reversePositive(-x);

    }

    public static int reversePositive(int x){
        String test = Integer.toString(x);
        int size = test.length();

        char[] testChars = test.toCharArray();
        int start = 0;
        int end = size - 1;
        while(start < end){
            char temp = testChars[start];
            testChars[start] = testChars[end];
            testChars[end] = temp;

            start ++;
            end --;
        }

        String resultString = new String(testChars);
        return Integer.valueOf(resultString);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123));
    }
}
