import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        cloneNode(map, node);
        return map.get(node.label);
    }

    public void cloneNode(Map<Integer, UndirectedGraphNode> map, UndirectedGraphNode node) {
        int currentLabel = node.label;
        if (!map.containsKey(currentLabel)) {
            map.put(currentLabel, new UndirectedGraphNode(currentLabel));
        }

        UndirectedGraphNode clone = map.get(currentLabel);
        for(UndirectedGraphNode n: node.neighbors) {
            if (!map.containsKey(n.label)) {
                map.put(n.label, new UndirectedGraphNode(n.label));
                cloneNode(map, n);
            }

            clone.neighbors.add(map.get(n.label));
        }

    }
}
