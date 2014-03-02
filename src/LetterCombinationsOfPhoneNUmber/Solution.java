package LetterCombinationsOfPhoneNUmber;

import java.util.ArrayList;

/**
 * Authored by GongLi at 23:55 on 1/3/14
 */


public class Solution {

    public ArrayList<String> letterCombinations(String digits) {


        String[] combinations = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<String>();

        String[] resultDigits = new String[digits.length()];
        for(int i = 0; i < resultDigits.length; i ++)
            resultDigits[i] = combinations[digits.charAt(i) - '0'];

        StringBuilder sb = new StringBuilder();
        getCombination(resultDigits, result, 0, sb);

        return result;
    }

    public void getCombination(String[] all, ArrayList<String> container, int step, StringBuilder re){

        int size = all.length;
        if(step == size){
            container.add(re.toString());
            return;
        }

        String cur = all[step];
        for(int i = 0; i < cur.length(); i ++){
            re.append(cur.charAt(i));
            getCombination(all, container, step + 1, re);
            re.deleteCharAt(re.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
