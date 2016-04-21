import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 13/4/2016.
 */
public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Node(i));
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] temp = prerequisites[i];
            Edge edge = new Edge(map.get(temp[1]), map.get(temp[0]));
            map.get(temp[1]).edgeList.add(edge);
            map.get(temp[0]).inboundValue = map.get(temp[0]).inboundValue + 1;
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.inboundValue, n2.inboundValue);
        });

        for (Node n : map.values()) {
            priorityQueue.add(n);
        }


        int runner = 0;
        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            if (cur.inboundValue != 0) {
                return new int[0];
            }

            for (Edge e: cur.edgeList) {
                e.to.inboundValue --;
                priorityQueue.remove(e.to);
                priorityQueue.add(e.to);
            }

            runner ++;
            result.add(cur.val);
        }

        if (runner == numCourses) {
            int[] s = new int[result.size()];
            for(int i = 0; i < result.size(); i ++) {
                s[i] = result.get(i);
            }
            return s;

        } else {
            return new int[0];
        }
    }


    public static class Node {
        int val;
        List<Edge> edgeList;
        int inboundValue;

        Node(int val) {
            this.val = val;
            edgeList = new ArrayList<>();
            inboundValue = 0;
        }
    }

    public static class Edge {
        Node from;
        Node to;

        Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] graph = new int[2][2];
        graph[0][0] = 0;
        graph[0][1] = 1;
        graph[1][0] = 1;
        graph[1][1] = 0;

        int[] result = courseSchedule.findOrder(2, graph);
        System.out.println();

    }
}
