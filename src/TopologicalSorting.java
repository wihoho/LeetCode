import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 6/6/2016.
 */
public class TopologicalSorting {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Stack<DirectedGraphNode> stack = new Stack<>();
        Set<DirectedGraphNode> visit = new HashSet<>();

        for(DirectedGraphNode directedGraphNode: graph) {
            if (!visit.contains(directedGraphNode)) {
                dfs(directedGraphNode, stack, visit);
            }
        }

        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public void dfs(DirectedGraphNode node, Stack<DirectedGraphNode> result, Set<DirectedGraphNode> set) {
        set.add(node);
        for(DirectedGraphNode neighbour: node.neighbors) {
            if (!set.contains(neighbour)) {
                dfs(neighbour, result, set);
            }
        }

        result.push(node);
    }
}
