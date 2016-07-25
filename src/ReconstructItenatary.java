import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/6/2016.
 */
public class ReconstructItenatary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return result;
        }

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(int i = 0; i < tickets.length; i ++) {
            if (!graph.containsKey(tickets[i][0])) {
                graph.put(tickets[i][0], new PriorityQueue<>());
            }

            graph.get(tickets[i][0]).add(tickets[i][1]);
        }

        dfs(graph, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String start, List<String> path) {
        while (graph.containsKey(start) && !graph.get(start).isEmpty()) {
            String next = graph.get(start).poll();
            dfs(graph, next, path);
        }

        path.add(start);
    }

    public static void main(String[] args) {
        ReconstructItenatary reconstructItenatary = new ReconstructItenatary();
        String[][] arr = new String[3][2];
        arr[0][0] = "JFK";
        arr[0][1] = "KUL";
        arr[1][0] = "JFK";
        arr[1][1] = "NRT";
        arr[2][0] = "NRT";
        arr[2][1] = "JFK";
//        arr[3][0] = "ATL";
//        arr[3][1] = "JFK";
//        arr[4][0] = "ATL";
//        arr[4][1] = "SFO";

        List<String> result = reconstructItenatary.findItinerary(arr);
        System.out.println();

    }
}
