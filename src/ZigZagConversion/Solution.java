package ZigZagConversion;

/**
 * Authored by GongLi at 12:28 on 28/2/14
 */


public class Solution {

    public String convert(String s, int nRows) {

        if(nRows <= 1) return s;

        String result = "";
        int sizeString = s.length();
        int zigSize = nRows* 2 - 2;
        for(int i = 0; i < nRows; i ++){
            for(int base = i; ; base += zigSize){
                if(base >= sizeString)
                    break;
                result += s.charAt(base);

                if(i >0 && i < nRows-1 && (base + zigSize - 2* i) < sizeString){
                    result += s.charAt(base + zigSize - 2* i);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = s.convert("123456789", 4);
        System.out.println(str);
    }
}
