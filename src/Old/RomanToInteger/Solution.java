package Old.RomanToInteger;

/**
 * Created by ligong on 15/12/2014.
 */
public class Solution {
    public static void main(String[] args) {
        Solution r = new Solution();
        System.out.println(r.romanToInt("IX"));
    }

    public int romanToInt(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i ++){

            if (i > 0 && convert(s.charAt(i-1)) < convert(s.charAt(i)))
                result = result - 2* convert(s.charAt(i-1)) + convert(s.charAt(i));

            else
                result += convert(s.charAt(i));

        }

        return result;

    }

    public int convert(char s){

        switch (s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }

    }
}
