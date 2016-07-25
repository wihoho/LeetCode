import java.util.ArrayList;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 6/6/2016.
 */
public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}

