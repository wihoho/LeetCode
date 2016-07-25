import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            if (!map.containsKey(curNode)) {
                map.put(curNode, new UndirectedGraphNode(curNode.label));
            }

            UndirectedGraphNode clone = map.get(curNode);

            for(UndirectedGraphNode neighbour: curNode.neighbors) {
                if (!set.contains(neighbour)) {
                    queue.add(neighbour);
                    set.add(neighbour);
                }

                if (!map.containsKey(neighbour)) {
                    map.put(neighbour, new UndirectedGraphNode(neighbour.label));
                }

                UndirectedGraphNode cloneNeighbout = map.get(neighbour);
                clone.neighbors.add(cloneNeighbout);
            }
        }

        return map.get(node);
    }
}
