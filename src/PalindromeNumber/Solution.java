package PalindromeNumber;

/**
 * Authored by GongLi at 21:05 on 28/2/14
 */


public class Solution {

    public boolean isPalindrome(int x){

        if(x < 0) return false;

        int numberDigit = 0;
        int testNum = x;

        while(testNum > 0){
            numberDigit ++;
            testNum /= 10;
        }

        int start = numberDigit - 1;
        int end = 0;
        while(start > end){
            int temp1 = getDigit(x, start);
            int temp3 = getDigit(x, end);

            if(temp1 != temp3)
                return false;

            start --;
            end ++;



        }


        return true;
    }


    public static int getDigit(int x, int index){

        if(index == 0) return x % 10;
        else{
            return (int)(x /= Math.pow(10,index)) % 10;
        }





    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome(1001);
    }
}
