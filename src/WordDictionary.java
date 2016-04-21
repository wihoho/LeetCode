import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    TrieNode root;

    public class TrieNode {
        String val;
        Map<Character, TrieNode> map;

        public TrieNode() {
            map = new HashMap<>();
        }
    }


    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word != null || word.length() >= 1) {
            addWord(word, 0, root);
        }
    }

    private void addWord(String word, int d, TrieNode current) {
        if (d == word.length()) {
            current.val = word;
            return;
        }

        char c = word.charAt(d);
        if (!current.map.containsKey(c)) {
            current.map.put(c, new TrieNode());
        }

        TrieNode node = current.map.get(c);
        addWord(word, d + 1, node);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        return search(word, 0, root);
    }


    private boolean search(String word, int d, TrieNode node) {
        if (d == word.length()) {
            if (node.val == null) {
                return false;
            }
            return true;
        }

        char c = word.charAt(d);
        if (c == '.') {

            for (TrieNode child : node.map.values()) {
                if (search(word, d + 1, child)) {
                    return true;
                }
            }

            return false;
        } else {
            if (node.map.containsKey(c)) {
                return search(word, d + 1, node.map.get(c));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println();
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}