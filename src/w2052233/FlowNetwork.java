

package w2052233;

import java.util.*;

public class FlowNetwork {
    private final int n;  // number of nodes
    private final List<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public FlowNetwork(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add an edge to the flow network
    public void addEdge(int from, int to, int capacity) {
        Edge e1 = new Edge(from, to, capacity);
        Edge e2 = new Edge(to, from, 0); // reverse edge
        e1.residual = e2;
        e2.residual = e1;
        adj[from].add(e1);
        adj[to].add(e2);
    }

    // Get adjacent edges for a node
    public List<Edge> getAdj(int node) {
        return adj[node];
    }

    public int size() {
        return n;
    }
}
