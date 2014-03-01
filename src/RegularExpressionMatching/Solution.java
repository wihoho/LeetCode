package RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert(p!=null && (p.length()==0 || p.charAt(0)!='*'));

        if(p.length()==0) return s.length()==0;

        if(p.length()==1 || p.charAt(1)!='*'){
            if(s.length()<1 || (p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0)))
                return false;
            return isMatch(s.substring(1),p.substring(1));

        }else{
            int i=-1;
            while(i<s.length() && (i<0 || p.charAt(0)=='.' || p.charAt(0)==s.charAt(i))){
                if(isMatch(s.substring(i+1),p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }

    }
}