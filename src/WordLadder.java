import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 16/3/2016.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Node> map = new HashMap<>();
        wordList.forEach(item -> {
            map.put(item, new Node(item));
        });
        map.put(endWord, new Node(endWord));

        // construct the graph
        Node current = new Node(beginWord);
        map.put(beginWord, current);
        Node desination = map.get(endWord);
        buildGraph(map, current, new HashSet<>());

        int[] minValue = new int[1];
        minValue[0] = Integer.MAX_VALUE;
        traverse(current, desination, minValue, 0);

        return minValue[0];
    }

    public void buildGraph(Map<String, Node> map, Node root, Set<String> alreadySet) {
        if (alreadySet.contains(root.value))
            return;

        alreadySet.add(root.value);

        String beginWord = root.value;
        for (int i = 0; i < beginWord.length(); i++) {
            char curChar = beginWord.charAt(i);

            for (char start = 'a'; start <= 'z'; start++) {
                if (curChar != start) {
                    String newString = beginWord.substring(0, i) + start + beginWord.substring(i + 1);
                    if (map.containsKey(newString)) {
                        root.adjacentNodes.add(map.get(newString));
                    }
                }
            }
        }

        for (Node adj : root.adjacentNodes) {
            buildGraph(map, adj, alreadySet);
        }
    }

    public void traverse(Node root, Node destination, int[] minValue, int currentValue) {
        if (root.value.equals(destination.value)) {
            if (minValue[0] > currentValue) {
                minValue[0] = currentValue;
            }

            return;
        }

        root.visited = true;

        currentValue += 1;
        for (Node n : root.adjacentNodes) {
            if (!n.visited) {
                traverse(n, destination, minValue, currentValue);
            }
        }
    }

    public static class Node {
        String value;
        List<Node> adjacentNodes;
        boolean visited;

        public Node(String value) {
            this.value = value;
            this.adjacentNodes = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();

        Set<String> words = new HashSet<>();
        words.add("a");
        words.add("b");
        words.add("c");

        int minPath = wordLadder.ladderLength("a", "c", words);
        System.out.println(minPath);
    }
}
