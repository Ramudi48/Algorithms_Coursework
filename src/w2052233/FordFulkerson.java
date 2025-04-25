/*
 * Student ID UOW: w2052233
 * Student ID IIT: 20232192
 * Name: Ramudi Munasinghe
 */

package w2052233;

import java.util.*;

public class FordFulkerson {
    private FlowNetwork network;

    public FordFulkerson(FlowNetwork network) {
        this.network = network;
    }

    // Function to perform a Depth-First Search (DFS) and find augmenting paths
    private boolean dfs(int source, int sink, boolean[] visited, List<Edge> path) {
        if (source == sink) {
            return true;
        }
        visited[source] = true;

        for (Edge edge : network.getAdj(source)) {
            if (!visited[edge.to] && edge.capacity > edge.flow) {
                path.add(edge);
                if (dfs(edge.to, sink, visited, path)) {
                    return true;
                }
                path.remove(path.size() - 1); // Backtrack if not successful
            }
        }
        return false;
    }

    // Ford-Fulkerson algorithm to calculate the maximum flow
    public int calculateMaxFlow(int source, int sink) {
        int maxFlow = 0;
        List<Edge> path = new ArrayList<>();

        while (true) {
            boolean[] visited = new boolean[network.size()];
            path.clear();

            // Find augmenting path using DFS
            if (!dfs(source, sink, visited, path)) {
                break; // No more augmenting paths
            }

            // Find the minimum residual capacity along the path
            int pathFlow = Integer.MAX_VALUE;
            for (Edge edge : path) {
                pathFlow = Math.min(pathFlow, edge.capacity - edge.flow);
            }

            // Augment flow and update residual capacities
            for (Edge edge : path) {
                edge.flow += pathFlow;
                edge.residual.flow -= pathFlow;
            }

            // Add the flow of this path to the total max flow
            maxFlow += pathFlow;

            // Output incremental improvement (i.e., flow added in this step)
            System.out.println("Augmenting Path: " + path);
            System.out.println("Flow added: " + pathFlow);
        }

        return maxFlow;
    }
}

