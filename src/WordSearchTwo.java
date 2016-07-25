import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/6/2016.
 */
public class WordSearchTwo {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearchTwo wordSearchTwo = new WordSearchTwo();
        wordSearchTwo.findWords(board, words);

        System.out.println();
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0) return result;

        // build the Trie
        Trie trie = new Trie();
        for (String s : words) {
            trie.addString(s);
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                help(board, i, j, trie.root, new StringBuffer(), result);
            }
        }

        return result;
    }

    private void help(char[][] board, int x, int y, Node root, StringBuffer sb, List<String> result) {
        if (root == null) return;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

        char cur = board[x][y];
        if (cur == '#') return;
        if (!root.map.containsKey(cur)) return;

        char temp = cur;
        board[x][y] = '#';

        sb.append(cur);

        Node nextNode = root.map.get(cur);
        if (nextNode.flag) {
            result.add(sb.toString());
            nextNode.flag = false;
        }
        help(board, x + 1, y, nextNode, sb, result);
        help(board, x - 1, y, nextNode, sb, result);
        help(board, x, y + 1, nextNode, sb, result);
        help(board, x, y - 1, nextNode, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        board[x][y] = temp;
    }


    private class Node {
        boolean flag;
        char cur;
        Map<Character, Node> map;

        public Node(char cur) {
            this.cur = cur;
            map = new HashMap<>();
        }
    }

    private class Trie {
        Node root;

        public Trie() {
            this.root = new Node(' ');
        }

        public void addString(String s) {
            if (s == null || s.length() == 0) return;

            Node currentNode = root;
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (!currentNode.map.containsKey(currentChar)) {
                    currentNode.map.put(currentChar, new Node(currentChar));
                }
                currentNode = currentNode.map.get(currentChar);

                if (i == s.length() - 1) {
                    currentNode.flag = true;
                }
            }
        }
    }
}
