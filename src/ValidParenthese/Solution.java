package ValidParenthese;

/**
 * Authored by GongLi at 11:12 on 2/3/14
 */


public class Solution {


    private static class Node {
        char val;
        Node next;

        Node(char x){
            val = x;
            next =null;
        }
    }


    private static class Stack{

        Node top;
        int size;

        public Stack(){
            top = null;
            size = 0;
        }

        public void push(Node cur){
            if(size == 0)    top = cur;

            else{
                cur.next = top;
                top = cur;
            }

            size ++;
        }

        public Node pop(){
            if(size == 0) return null;
            Node tem= top;
            top = top.next;
            size --;
            return tem;


        }

    }

    public boolean isValid(String s) {

        if(s == null || s.length() == 0) return true;
        if(s.length() == 1) return false;

        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i ++){
            char x = s.charAt(i);
            if(x == '(' || x == '[' || x == '{') stack.push(new Node(x));
            else{

                if(stack.size != 0){
                    char test = stack.pop().val;
                if(x == ')' && test == '(')
                    continue;
                else if(x == ']' && test == '[')
                    continue;
                else if(x == '}' && test == '{')
                    continue;
                else
                    return false;    }
                else return false;
            }
        }

        if(stack.size == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(("));
    }
}
