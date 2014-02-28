package StringToInteger;

import com.sun.corba.se.spi.activation._RepositoryStub;

/**
 * Authored by GongLi at 20:34 on 28/2/14
 */


public class Solution {

    public int atoi(String str){
        if(str == null) return 0;
        int size = str.length();
        if(size == 0) return 0;
        str = str.trim();
        size = str.length();

        boolean negativeFlag = false;

        if(str.charAt(0) == '-') negativeFlag = true;

        int startIndex = 0;
        if(negativeFlag) startIndex = 1;
        if(str.charAt(0) == '+') startIndex ++;

        double result = 0;
        for(; startIndex < size; startIndex ++){
            char x = str.charAt(startIndex);
            if( x < '0' || x > '9') break;

            result = result * 10 + x - '0';
        }

        if(negativeFlag){
            if(result > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            return 0 - (int)result;

        }
        else{
            if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            return (int) result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

            System.out.println(s.atoi("     -0012a42"));
            System.out.println(s.atoi("-1"));
            System.out.println(s.atoi("0"));
            System.out.println(s.atoi("1000000000"));
            System.out.println(s.atoi("2147483648"));

    }


}
