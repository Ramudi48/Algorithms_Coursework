/*
 * Student ID UOW: w2052233
 * Student ID IIT: 20232192
 * Name: Ramudi Munasinghe
 */

package w2052233;

public class Edge {
    int from, to, capacity, flow;
    Edge residual;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 1;
    }

    @Override
    public String toString() {
        return String.format("Edge(%d -> %d, capacity=%d, flow=%d)", from, to, capacity, flow);
    }
}
