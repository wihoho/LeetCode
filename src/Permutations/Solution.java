package Permutations;

import java.util.ArrayList;

/**
 * Authored by GongLi at 21:26 on 28/2/14
 */


public class Solution {

    public static ArrayList<String> getPermutations(ArrayList<String> old, char x){
        if(old.size() == 0) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(Character.toString(x));
            return temp;
        }

        ArrayList<String> cur = new ArrayList<String>();
        for(String check: old){
            int sizeOfCheck = check.length();
            for(int i = 0; i <= sizeOfCheck; i ++){
                String temp = check.substring(0,i) + Character.toString(x) + check.substring(i, sizeOfCheck);
                cur.add(temp);
            }
        }

        return cur;
    }


    public static ArrayList<String> findAllPermutations(String s){

        if(s == null || s.length() == 0) return null;

        ArrayList<String> cur = new ArrayList<String>();
        for(int i= 0; i < s.length(); i ++){
            cur = getPermutations(cur, s.charAt(i));
        }

        return cur;

    }


    public static void main(String[] args) {

        ArrayList<String> update = findAllPermutations("abc");
        for(String s:update)
            System.out.println(s);
    }

}
