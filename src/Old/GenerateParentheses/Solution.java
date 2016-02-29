package Old.GenerateParentheses;

import java.util.ArrayList;

/**
 * Authored by GongLi at 12:05 on 2/3/14
 */


public class Solution {

    public ArrayList<String> generateParenthesis(int n) {

        ArrayList<String> result = new ArrayList<String>();
        if(n <= 0) return result;

        generate(result, "", 0, 0, n);
        return result;
    }


    public void generate(ArrayList<String> result, String temp, int lp, int rp, int n){
        if(lp == n){
            for(int i = rp; i < n; i ++)
                temp += ')';

            result.add(temp);
            return;
        }

        generate(result, temp + '(', lp + 1, rp, n);

        if (lp > rp)
            generate(result, temp + ')', lp, rp + 1, n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generateParenthesis(3));
    }
}
